import java.util.*;
import java.io.*;

public class Main {
    static long[] pref;

    static int search(long r) {
        int lo = 0, hi = pref.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (pref[mid] < r) lo = mid + 1;
            else hi = mid;
        }
        return lo + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int q = Integer.parseInt(tok.nextToken());

        pref = new long[n];
        long total = 0;
        tok = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(tok.nextToken());
            total += a;
            pref[i] = total;
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long x = Long.parseLong(reader.readLine().trim());
            long r = (x - 1) % total + 1;
            out.append(search(r)).append("\n");
        }
        System.out.print(out);
    }
}