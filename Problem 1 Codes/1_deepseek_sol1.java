import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String[] firstLine = br.readLine().trim().split("\\s+");
            int n = Integer.parseInt(firstLine[0]);
            int x = Integer.parseInt(firstLine[1]);

            String[] secondLine = br.readLine().trim().split("\\s+");
            int[] a = new int[n];
            int pos = -1;

            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(secondLine[i]);
                if (a[i] == x) {
                    pos = i;
                }
            }

            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i <= pos; i++) {
                if (a[i] < minVal)
                    minVal = a[i];
                if (a[i] > maxVal)
                    maxVal = a[i];
            }

            if (maxVal - minVal + 1 == pos + 1) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}