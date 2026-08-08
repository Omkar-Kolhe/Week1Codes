import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken(); int n = (int) st.nval;
        st.nextToken(); int q = (int) st.nval;

        long[] prefix = new long[n];
        long total = 0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            total += (long) st.nval;
            prefix[i] = total;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st.nextToken();
            long x = (long) st.nval;
            long r = (x - 1) % total + 1;
            int idx = Arrays.binarySearch(prefix, r);
            if (idx < 0) idx = -(idx + 1);
            sb.append(idx + 1).append("\n");
        }
        System.out.print(sb);
    }
}