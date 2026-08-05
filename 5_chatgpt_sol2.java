import java.util.*;

public class Main {

    static final long MOD = 998244353L;

    static long powerOfTen(int digits) {
        long result = 1;
        long base = 10;

        while (digits > 0) {
            if ((digits & 1) == 1)
                result = (result * base) % MOD;

            base = (base * base) % MOD;
            digits >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            int size = sc.nextInt();

            String[] numbers = new String[size];

            for (int i = 0; i < size; i++)
                numbers[i] = String.valueOf(sc.nextLong());

            Arrays.sort(numbers, (first, second) -> (second + first).compareTo(first + second));

            long answer = 0;

            for (String current : numbers) {
                long currentValue = 0;

                for (int i = 0; i < current.length(); i++)
                    currentValue = (currentValue * 10 + current.charAt(i) - '0') % MOD;

                answer = (answer * powerOfTen(current.length())) % MOD;
                answer = (answer + currentValue) % MOD;
            }

            System.out.println(answer);
        }

        sc.close();
    }
}
