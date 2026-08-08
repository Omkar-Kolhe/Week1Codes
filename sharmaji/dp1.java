import java.util.*;
public class dp1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), q = s.nextInt();
        long[] p = new long[n + 1];
        for (int i = 1; i <= n; i++)
            p[i] = p[i - 1] + s.nextInt();
        long t = p[n];
        while (q-- > 0) {
            long x = s.nextLong();
            x = (x - 1) % t + 1;
            int i = Arrays.binarySearch(p, x);
            if (i < 0) i = -i - 1;
            System.out.p    rintln(i);
        }
    }
}