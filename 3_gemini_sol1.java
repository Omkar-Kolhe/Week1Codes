import java.util.Scanner;

public class Main {
    private static long getGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()) {
            long M = scanner.nextLong();
            long temp = M;
            long rad = 1;
            
            for (long i = 2; i * i <= temp; i++) {
                if (temp % i == 0) {
                    rad *= i;
                    while (temp % i == 0) {
                        temp /= i;
                    }
                }
            }
            if (temp > 1) {
                rad *= temp;
            }

            long count = 0;
            for (long x = 1; x < M; x++) {
                long g = getGcd(x, rad);
                long req = rad / g;
                count += (M - 1) / req;
            }
            
            System.out.println(count);
        }
        scanner.close();
    }
}
