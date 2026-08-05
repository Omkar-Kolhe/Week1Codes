import java.util.*;

public class Main {

    static int k, states, FULL;
    static int[] mult;
    static int[][] vec, add;
    static int[] expLim;
    static HashMap<Long, Boolean> memo = new HashMap<>();

    static int encode(int[] a) {
        int id = 0;
        for (int i = 0; i < k; i++)
            id += a[i] * mult[i];
        return id;
    }

    static boolean solve(int A, int B) {
        long key = (((long) A) << 32) | (B & 0xffffffffL);
        if (memo.containsKey(key))
            return memo.get(key);

        int C = add[A][B];

        if (C == FULL) {
            memo.put(key, true);
            return true;
        }

        if (C == B) {
            memo.put(key, false);
            return false;
        }

        boolean res = solve(B, C);
        memo.put(key, res);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<Integer> exps = new ArrayList<>();

        int t = M;

        for (int p = 2; p * p <= t; p++) {
            if (t % p == 0) {
                int c = 0;
                while (t % p == 0) {
                    t /= p;
                    c++;
                }
                primes.add(p);
                exps.add(c);
            }
        }

        if (t > 1) {
            primes.add(t);
            exps.add(1);
        }

        k = primes.size();

        mult = new int[k];
        expLim = new int[k];

        states = 1;

        for (int i = 0; i < k; i++) {
            mult[i] = states;
            expLim[i] = exps.get(i);
            states *= (expLim[i] + 1);
        }

        FULL = states - 1;

        vec = new int[states][k];

        for (int id = 0; id < states; id++) {
            int x = id;
            for (int i = 0; i < k; i++) {
                vec[id][i] = x % (expLim[i] + 1);
                x /= (expLim[i] + 1);
            }
        }

        add = new int[states][states];

        for (int a = 0; a < states; a++) {
            for (int b = 0; b < states; b++) {
                int[] c = new int[k];
                for (int i = 0; i < k; i++)
                    c[i] = Math.min(expLim[i], vec[a][i] + vec[b][i]);
                add[a][b] = encode(c);
            }
        }

        int[] stateVal = new int[M];

        for (int v = 1; v < M; v++) {
            int[] c = new int[k];
            int x = v;

            for (int i = 0; i < k; i++) {
                while (x % primes.get(i) == 0) {
                    c[i]++;
                    x /= primes.get(i);
                }
            }

            stateVal[v] = encode(c);
        }

        long ans = 0;

        for (int x = 1; x < M; x++)
            for (int y = 1; y < M; y++)
                if (solve(stateVal[x], stateVal[y]))
                    ans++;

        System.out.println(ans);
    }
}
