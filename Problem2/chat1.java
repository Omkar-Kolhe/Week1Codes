import java.util.*;

public class chat1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += sc.nextLong();
        }

        if (sum % N == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}