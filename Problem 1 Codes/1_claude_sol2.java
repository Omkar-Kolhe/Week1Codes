

import java.io.*;
import java.util.*;

class Main {

    private static long[] findRangeBounds(long target, HashSet<Long> valueSet) {
        long lo = target;
        long hi = target;
        while (valueSet.contains(lo - 1))
            lo--;
        while (valueSet.contains(hi + 1))
            hi++;
        return new long[] { lo, hi };
    }

    private static String solveCase(long frontVal, long x, HashSet<Long> valueSet) {
        long[] bounds = findRangeBounds(x, valueSet);
        long lo = bounds[0], hi = bounds[1];
        return (frontVal >= lo && frontVal <= hi) ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int t = (int) st.nval;

        StringBuilder out = new StringBuilder();

        for (int tc = 0; tc < t; tc++) {
            st.nextToken();
            int n = (int) st.nval;
            st.nextToken();
            long x = (long) st.nval;

            long[] queue = new long[n];
            HashSet<Long> valueSet = new HashSet<>(n * 2);
            for (int i = 0; i < n; i++) {
                st.nextToken();
                queue[i] = (long) st.nval;
                valueSet.add(queue[i]);
            }

            out.append(solveCase(queue[0], x, valueSet)).append('\n');
        }

        System.out.print(out);
    }
}