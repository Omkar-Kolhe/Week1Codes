import java.util.Scanner;

public class gemini2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] nums = new int[n];
        
        // Use long instead of int to prevent integer overflow!
        long sum = 0; 
        
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
            sum += nums[i];
        }

        if (sum % n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        
        input.close();
    }
}
