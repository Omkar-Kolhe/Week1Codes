import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class gemini2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int arraySize = Integer.parseInt(tokenizer.nextToken());
        int numQueries = Integer.parseInt(tokenizer.nextToken());

        long[] prefixSums = new long[arraySize];
        long totalSequenceLength = 0;

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            long frequency = Long.parseLong(tokenizer.nextToken());
            totalSequenceLength += frequency;
            prefixSums[i] = totalSequenceLength;
        }

        StringBuilder outputBuilder = new StringBuilder();

        for (int i = 0; i < numQueries; i++) {
            long targetIndex = Long.parseLong(reader.readLine().trim());
            long effectiveIndex = (targetIndex - 1) % totalSequenceLength + 1;

            int low = 0;
            int high = arraySize - 1;
            int elementValue = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] >= effectiveIndex) {
                    elementValue = mid + 1;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            outputBuilder.append(elementValue).append("\n");
        }
        
        System.out.print(outputBuilder.toString());
    }
}