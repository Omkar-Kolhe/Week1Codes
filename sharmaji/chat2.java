import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int q = fs.nextInt();

        long[] prefix = new long[n];
        long cycle = 0;

        for (int i = 0; i < n; i++) {
            cycle += fs.nextLong();
            prefix[i] = cycle;
        }

        StringBuilder ans = new StringBuilder();

        while (q-- > 0) {
            long x = fs.nextLong();
            x = (x - 1) % cycle + 1;

            int lo = 0;
            int hi = n - 1;

            while (lo < hi) {
                int mid = (lo + hi) >>> 1;

                if (prefix[mid] >= x)
                    hi = mid;
                else
                    lo = mid + 1;
            }

            ans.append(lo + 1).append('\n');
        }

        System.out.print(ans);
    }
}