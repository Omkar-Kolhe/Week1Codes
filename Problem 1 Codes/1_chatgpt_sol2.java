import java.io.*;
import java.util.*;

class Main {

    static boolean canMove(long[] arr, long x) {
        long first = arr[0];

        if (first == x) {
            return true;
        }

        long[] sorted = arr.clone();
        Arrays.sort(sorted);

        int firstPos = -1;
        int xPos = -1;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == first) {
                firstPos = i;
            }

            if (sorted[i] == x) {
                xPos = i;
            }
        }

        int left = Math.min(firstPos, xPos);
        int right = Math.max(firstPos, xPos);

        for (int i = left; i < right; i++) {
            if (sorted[i + 1] - sorted[i] != 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            long x = Long.parseLong(st.nextToken());

            long[] arr = new long[n];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            System.out.println(canMove(arr, x) ? "YES" : "NO");
        }
    }
}