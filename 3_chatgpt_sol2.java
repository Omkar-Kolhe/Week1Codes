import java.util.*;

public class Main {

    // Stores prime factors of M and their required exponents.
    static ArrayList<Integer> primes = new ArrayList<>();
    static ArrayList<Integer> requiredExponents = new ArrayList<>();

    // Number of distinct prime factors.
    static int factorCount;

    // Total number of compressed states.
    static int totalStates;

    // Used for encoding exponent vectors into a single integer.
    static int[] stateMultiplier;

    // Decoded exponent values for every state.
    static int[][] stateValues;

    // Precomputed transition table.
    static int[][] mergedState;

    // Memoization for recursion.
    static HashMap<Long, Boolean> memo = new HashMap<>();

    // Converts exponent vector into encoded state.
    static int encodeState(int[] exponents) {

        int state = 0;

        for (int i = 0; i < factorCount; i++) {
            state += exponents[i] * stateMultiplier[i];
        }

        return state;
    }

    // Returns true if this starting pair eventually produces
    // a number divisible by M.
    static boolean isCursed(int firstState, int secondState) {

        long key = (((long) firstState) << 32) | (secondState & 0xffffffffL);

        if (memo.containsKey(key))
            return memo.get(key);

        int nextState = mergedState[firstState][secondState];

        // Required exponents for every prime factor are collected.
        if (nextState == totalStates - 1) {
            memo.put(key, true);
            return true;
        }

        // Sequence stops changing.
        if (nextState == secondState) {
            memo.put(key, false);
            return false;
        }

        boolean result = isCursed(secondState, nextState);
        memo.put(key, result);

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        // ---------------- Prime Factorization ----------------

        int temp = M;

        for (int p = 2; p * p <= temp; p++) {

            if (temp % p != 0)
                continue;

            int exponent = 0;

            while (temp % p == 0) {
                exponent++;
                temp /= p;
            }

            primes.add(p);
            requiredExponents.add(exponent);
        }

        if (temp > 1) {
            primes.add(temp);
            requiredExponents.add(1);
        }

        factorCount = primes.size();

        // ---------------- State Encoding ----------------

        stateMultiplier = new int[factorCount];

        totalStates = 1;

        for (int i = 0; i < factorCount; i++) {
            stateMultiplier[i] = totalStates;
            totalStates *= (requiredExponents.get(i) + 1);
        }

        stateValues = new int[totalStates][factorCount];

        for (int state = 0; state < totalStates; state++) {

            int value = state;

            for (int i = 0; i < factorCount; i++) {

                int limit = requiredExponents.get(i) + 1;

                stateValues[state][i] = value % limit;
                value /= limit;
            }
        }

        // ---------------- Precompute State Transitions ----------------

        mergedState = new int[totalStates][totalStates];

        for (int stateA = 0; stateA < totalStates; stateA++) {

            for (int stateB = 0; stateB < totalStates; stateB++) {

                int[] combined = new int[factorCount];

                for (int i = 0; i < factorCount; i++) {

                    combined[i] = Math.min(
                            requiredExponents.get(i),
                            stateValues[stateA][i] + stateValues[stateB][i]
                    );
                }

                mergedState[stateA][stateB] = encodeState(combined);
            }
        }

        // ---------------- State of Every Number ----------------

        int[] numberState = new int[M];

        for (int number = 1; number < M; number++) {

            int value = number;
            int[] exponents = new int[factorCount];

            for (int i = 0; i < factorCount; i++) {

                int prime = primes.get(i);

                while (value % prime == 0) {
                    exponents[i]++;
                    value /= prime;
                }
            }

            numberState[number] = encodeState(exponents);
        }

        // ---------------- Count Cursed Pairs ----------------

        long answer = 0;

        for (int x = 1; x < M; x++) {

            for (int y = 1; y < M; y++) {

                if (isCursed(numberState[x], numberState[y])) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
