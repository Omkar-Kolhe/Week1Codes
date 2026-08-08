import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        
        int t = Integer.parseInt(line.trim());
        long mod = 998244353;
        StringBuilder out = new StringBuilder();
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] a = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int i = 0; i < n; i++) {
                a[i] = st.nextToken();
            }
            
            Arrays.sort(a, (x, y) -> (y + x).compareTo(x + y));
            
            long ans = 0;
            for (String s : a) {
                long p = 1;
                long val = 0;
                for (int i = 0; i < s.length(); i++) {
                    p = (p * 10) % mod;
                    val = (val * 10 + (s.charAt(i) - '0')) % mod;
                }
                ans = (ans * p % mod + val) % mod;
            }
            
            out.append(ans).append("\n");
        }
        
        System.out.print(out);
    }
}
