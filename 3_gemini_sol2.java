import java.util.Scanner;

public class SequenceSolver {
    private static long calculateGreatestCommonDivisor(long first, long second) {
        while (second != 0) {
            long remainder = first % second;
            first = second;
            second = remainder;
        }
        return first;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        if (inputScanner.hasNextLong()) {
            long modulus = inputScanner.nextLong();
            long remainingValue = modulus;
            long squareFreeProduct = 1;
            
            for (long divisor = 2; divisor * divisor <= remainingValue; divisor++) {
                if (remainingValue % divisor == 0) {
                    squareFreeProduct *= divisor;
                    while (remainingValue % divisor == 0) {
                        remainingValue /= divisor;
                    }
                }
            }
            
            if (remainingValue > 1) {
                squareFreeProduct *= remainingValue;
            }

            long cursedPairCount = 0;
            for (long startX = 1; startX < modulus; startX++) {
                long currentGcd = calculateGreatestCommonDivisor(startX, squareFreeProduct);
                long requiredYFactor = squareFreeProduct / currentGcd;
                cursedPairCount += (modulus - 1) / requiredYFactor;
            }
            
            System.out.println(cursedPairCount);
        }
        inputScanner.close();
    }
}
