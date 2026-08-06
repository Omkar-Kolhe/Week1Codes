import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Initialize fast I/O readers
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();
        if (line == null) return;
        
        StringTokenizer st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        long totalMilk = 0;
        
        for (int i = 0; i < n; i++) {
            totalMilk += Long.parseLong(st.nextToken());
        }
        
        // Ternary operator for concise output
        System.out.println(totalMilk % n == 0 ? "YES" : "NO");
    }
}
