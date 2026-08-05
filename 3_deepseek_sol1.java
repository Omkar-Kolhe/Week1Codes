import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        
        List<Integer> primeFactors = new ArrayList<>();
        int temp = M;
        for (int p = 2; p * p <= temp; p++) {
            if (temp % p == 0) {
                primeFactors.add(p);
                while (temp % p == 0) temp /= p;
            }
        }
        if (temp > 1) primeFactors.add(temp);
        
        int count = 0;
        for (int x = 1; x <= M - 1; x++) {
            for (int y = 1; y <= M - 1; y++) {
                boolean cursed = false;
                for (int p : primeFactors) {
                    int expX = 0, expY = 0;
                    int tx = x, ty = y;
                    while (tx % p == 0) { expX++; tx /= p; }
                    while (ty % p == 0) { expY++; ty /= p; }
                    
                    if (expX == 0 && expY == 0) continue;
                    if (expX > 0 || expY > 0) {
                        cursed = true;
                        break;
                    }
                }
                if (cursed) count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}
