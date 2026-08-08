import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        long mod = 998244353;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        StringBuilder output = new StringBuilder();

        while (testCases-- > 0) {
            int n = Integer.parseInt(reader.readLine().trim());
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            String[] numbers = new String[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = tokenizer.nextToken();
            }

            Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

            long answer = 0;
            for (String num : numbers) {
                long power = 1;
                for (int j = 0; j < num.length(); j++) {
                    power = (power * 10) % mod;
                }
                long digitValue = Long.parseLong(num) % mod;
                answer = (answer * power + digitValue) % mod;
            }

            output.append(answer).append("\n");
        }

        System.out.print(output);
    }
}
