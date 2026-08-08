import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final long MOD = 998244353;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        int t = (int) in.nval;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            in.nextToken();
            int n = (int) in.nval;
            String[] a = new String[n];
            for (int i = 0; i < n; i++) {
                in.nextToken();
                a[i] = String.valueOf((long) in.nval);
            }
            Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
            long res = 0;
            for (String s : a) {
                long p10 = 1;
                for (int j = 0; j < s.length(); j++) p10 = (p10 * 10) % MOD;
                res = (res * p10 + Long.parseLong(s) % MOD) % MOD;
            }
            sb.append(res).append('\n');
        }
        System.out.print(sb);
    }
}
