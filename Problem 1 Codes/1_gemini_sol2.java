import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Removed 'public' so this can be saved in any file (e.g., 1_gemini_sol2.java)
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

            // Sort the array to align consecutive ranks
            Arrays.sort(arr);

            // Locate the positions of the two values
            int posFirst = Arrays.binarySearch(arr, firstVal);
            int posTarget = Arrays.binarySearch(arr, targetX);

            int indexDiff = Math.abs(posFirst - posTarget);
            int valueDiff = Math.abs(firstVal - targetX);

            // If the differences match, no numbers are missing between them
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