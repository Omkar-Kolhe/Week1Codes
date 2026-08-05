import java.util.Scanner;

public class d2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();           
        long totalMilk = 0;              

        int[] milk = new int[n];           
        for (int i = 0; i < n; i++) {
            milk[i] = input.nextInt();
            totalMilk += milk[i];         
        }

     
        if (totalMilk % n == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        input.close(); 
    }

}
