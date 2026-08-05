import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long[] a = new long[n];
            HashSet<Long> present = new HashSet<>();

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
                present.add(a[i]);
            }

            long low = Math.min(a[0], x);
            long high = Math.max(a[0], x);

            boolean possible = true;

            for (long value = low; value <= high; value++) {
                if (!present.contains(value)) {
                    possible = false;
                    break;
                }
            }

            System.out.println(possible ? "YES" : "NO");
        }
    }
}