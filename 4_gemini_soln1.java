import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            long totalMilk = 0;
            
            for (int i = 0; i < n; i++) {
                totalMilk += sc.nextLong();
            }
            
            if (totalMilk % n == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
