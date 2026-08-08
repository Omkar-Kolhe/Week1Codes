import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    static long modPow10(int len) {
        long res = 1;
        long base = 10;

        while (len > 0) {
            if ((len & 1) == 1)
                res = (res * base) % MOD;
            base = (base * base) % MOD;
            len >>= 1;
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {

            int N = sc.nextInt();

            String[] arr = new String[N];

            for (int i = 0; i < N; i++)
                arr[i] = String.valueOf(sc.nextLong());

            Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

            long ans = 0;

            for (String s : arr) {

                long val = 0;

                for (int i = 0; i < s.length(); i++)
                    val = (val * 10 + (s.charAt(i) - '0')) % MOD;

                ans = (ans * modPow10(s.length())) % MOD;
                ans = (ans + val) % MOD;
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
