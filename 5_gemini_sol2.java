import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) {
            return;
        }
        
        int testCases = scanner.nextInt();
        long moduloValue = 998244353;
        
        while (testCases > 0) {
            int arraySize = scanner.nextInt();
            String[] numbers = new String[arraySize];
            
            for (int i = 0; i < arraySize; i++) {
                numbers[i] = scanner.next();
            }
            
            Arrays.sort(numbers, new Comparator<String>() {
                @Override
                public int compare(String first, String second) {
                    String option1 = first + second;
                    String option2 = second + first;
                    return option2.compareTo(option1);
                }
            });
            
            long finalResult = 0;
            for (String numberStr : numbers) {
                long multiplier = 1;
                long currentValue = 0;
                
                for (int i = 0; i < numberStr.length(); i++) {
                    multiplier = (multiplier * 10) % moduloValue;
                    currentValue = (currentValue * 10 + (numberStr.charAt(i) - '0')) % moduloValue;
                }
                
                finalResult = (finalResult * multiplier % moduloValue + currentValue) % moduloValue;
            }
            
            System.out.println(finalResult);
            testCases--;
        }
        
        scanner.close();
    }
}
