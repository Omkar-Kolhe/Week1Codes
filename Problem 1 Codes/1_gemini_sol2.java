import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String line = reader.readLine();
        if (line == null || line.trim().isEmpty())
            return;

        int testCases = Integer.parseInt(line.trim());

        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int firstVal = arr[0];

            if (firstVal == targetX) {
                writer.println("YES");
                continue;
            }

        
            Arrays.sort(arr);

            int posFirst = Arrays.binarySearch(arr, firstVal);
            int posTarget = Arrays.binarySearch(arr, targetX);

            int indexDiff = Math.abs(posFirst - posTarget);
            int valueDiff = Math.abs(firstVal - targetX);


            if (indexDiff == valueDiff) {
                writer.println("YES");
            } else {
                writer.println("NO");
            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}