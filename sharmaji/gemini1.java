import java.io.*;
import java.util.*;

public class gemini1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        long[] p = new long[n];
        long s = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            s += Integer.parseInt(st.nextToken());
            p[i] = s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long x = Long.parseLong(br.readLine().trim());
            long rem = (x - 1) % s + 1;
            int l = 0, r = n - 1, ans = -1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (p[mid] >= rem) {
                    ans = mid + 1;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}