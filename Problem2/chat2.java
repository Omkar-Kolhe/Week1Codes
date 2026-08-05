
import java.util.Scanner;

public class chat2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        long totalMilk = 0;

        for (int i = 0; i < n; i++) {
            totalMilk += input.nextLong();
        }

        if (totalMilk % n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        input.close();
    }
}