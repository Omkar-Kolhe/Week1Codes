import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine().trim());

        for (int testCase = 0; testCase < t; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            int pos = 0;

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
                if (a[i] == x) {
                    pos = i;
                }
            }

            Set<Integer> prefixSet = new HashSet<>();
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i <= pos; i++) {
                prefixSet.add(a[i]);
                minVal = Math.min(minVal, a[i]);
                maxVal = Math.max(maxVal, a[i]);
            }

            boolean possible = (prefixSet.size() == pos + 1)
                    && (maxVal - minVal + 1 == prefixSet.size());

            pw.println(possible ? "YES" : "NO");
        }

        pw.flush();
    }
}