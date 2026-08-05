import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Removed 'public' so this can be saved in any file (e.g., 1_gemini_sol1.java)
class Main {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int[] queue = new int[n];
            for (int i = 0; i < n; i++) {
                queue[i] = scanner.nextInt();
            }

            int startElement = queue[0];

            if (startElement == x) {
                out.println("YES");
                continue;
            }

            int minVal = Math.min(startElement, x);
            int maxVal = Math.max(startElement, x);

            // The number of elements required to form a contiguous sequence
            // Using long to prevent any potential overflow issues during subtraction
            long requiredLength = (long) maxVal - minVal + 1;

            if (requiredLength > n) {
                out.println("NO");
                continue;
            }

            int countInRange = 0;
            for (int i = 0; i < n; i++) {
                if (queue[i] >= minVal && queue[i] <= maxVal) {
                    countInRange++;
                }
            }

            if (countInRange == requiredLength) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
        out.flush();
    }

    // Standard fast I/O class for competitive programming
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null)
                        return null;
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}