import java.io.*;
import java.util.*;
public class dp2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrayLength = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());
        long[] prefixSum = new long[arrayLength + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= arrayLength; ++i) {
            int frequency = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + frequency;
        }
        long sequenceLength = prefixSum[arrayLength];
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < queryCount; ++q) {
            long targetIndex = Long.parseLong(br.readLine());
            long position = (targetIndex - 1) % sequenceLength + 1;
            int idx = Arrays.binarySearch(prefixSum, position);
            if (idx < 0) idx = -idx - 1;
            sb.append(idx).append('\n');
        }
        System.out.print(sb);
    }
}