import java.util.Scanner;

public class d2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();           // number of glasses
        long totalMilk = 0;                // use long to handle up to 1e14 total milk

        int[] milk = new int[n];           // array to store the amount in each glass (optional)
        for (int i = 0; i < n; i++) {
            milk[i] = input.nextInt();
            totalMilk += milk[i];          // add current glass to the total
        }

        // If the total milk can be divided equally among all glasses, print YES
        if (totalMilk % n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        input.close();  // close the scanner to prevent resource leak
    }

}
