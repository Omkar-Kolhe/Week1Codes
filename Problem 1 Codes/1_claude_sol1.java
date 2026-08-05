
// Solution 1: Sort + block grouping using HashMap
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
        int T = nextInt(in);
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = nextInt(in);
            long X = nextLong(in);

            long[] arr = new long[N];
            for (int i = 0; i < N; i++)
                arr[i] = nextLong(in);

            long[] sortedVals = arr.clone();
            Arrays.sort(sortedVals);

            // Assign block ids: values forming a contiguous run (consecutive
            // integers present in the array) belong to the same block,
            // since within a block any permutation is reachable via
            // repeated adjacent-value swaps.
            HashMap<Long, Integer> blockOf = new HashMap<>(N * 2);
            int currentBlock = 0;
            blockOf.put(sortedVals[0], currentBlock);
            for (int i = 1; i < N; i++) {
                if (sortedVals[i] - sortedVals[i - 1] != 1) {
                    currentBlock++;
                }
                blockOf.put(sortedVals[i], currentBlock);
            }

            int frontBlock = blockOf.get(arr[0]);
            int targetBlock = blockOf.get(X);

            sb.append(frontBlock == targetBlock ? "YES" : "NO").append('\n');
        }

        System.out.print(sb);
    }

    private static int nextInt(DataInputStream in) throws IOException {
        int ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == -1)
                return -1;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }

    private static long nextLong(DataInputStream in) throws IOException {
        long ret = 0;
        int b = in.read();
        while (b < '0' || b > '9') {
            if (b == -1)
                return -1;
            b = in.read();
        }
        while (b >= '0' && b <= '9') {
            ret = ret * 10 + (b - '0');
            b = in.read();
        }
        return ret;
    }
}