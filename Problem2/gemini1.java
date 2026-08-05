import java.util.Scanner;

public class gemini1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long totalSum = 0;
            
            for (int i = 0; i < n; i++) {
                totalSum += sc.nextLong();
            }
            
            // If the sum is divisible by n, it's possible to equalize
            if (totalSum % n == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
