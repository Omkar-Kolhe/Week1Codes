import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            List<String> list = new ArrayList<>();
            for (String s : arr) list.add(s);
            list.sort((a, b) -> (b + a).compareTo(a + b));
            StringBuilder sb = new StringBuilder();
            for (String s : list) sb.append(s);
            long ans = 0;
            for (char c : sb.toString().toCharArray()) {
                ans = (ans * 10 + (c - '0')) % MOD;
            }
            System.out.println(ans);
        }
    }
}
