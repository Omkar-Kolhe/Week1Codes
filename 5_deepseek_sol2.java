import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] numbers = br.readLine().split(" ");
            
            List<String> list = new ArrayList<>();
            for (String num : numbers) {
                list.add(num);
            }
            
            Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    String order1 = a + b;
                    String order2 = b + a;
                    return order2.compareTo(order1);
                }
            });
            
            StringBuilder result = new StringBuilder();
            for (String num : list) {
                result.append(num);
            }
            
            long answer = 0;
            String finalNumber = result.toString();
            for (int i = 0; i < finalNumber.length(); i++) {
                int digit = finalNumber.charAt(i) - '0';
                answer = (answer * 10 + digit) % MOD;
            }
            
            System.out.println(answer);
        }
    }
}
