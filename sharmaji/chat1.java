import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int q = fs.nextInt();

        long[] prefix = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += fs.nextLong();
            prefix[i] = total;
        }

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            long x = fs.nextLong();
            long pos = (x - 1) % total + 1;

            int left = 0, right = n - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (prefix[mid] >= pos)
                    right = mid;
                else
                    left = mid + 1;
            }

            out.append(left + 1).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long value = 0;
            while (c > ' ') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}