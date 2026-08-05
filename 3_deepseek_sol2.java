import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        
        List<Integer> primeFactors = new ArrayList<>();
        int number = M;
        for (int p = 2; p * p <= number; p++) {
            if (number % p == 0) {
                primeFactors.add(p);
                while (number % p == 0) number /= p;
            }
        }
        if (number > 1) primeFactors.add(number);
        
        int cursedPairs = 0;
        
        for (int x = 1; x < M; x++) {
            for (int y = 1; y < M; y++) {
                boolean isCursed = false;
                
                for (int prime : primeFactors) {
                    int powerX = 0, powerY = 0;
                    int tempX = x, tempY = y;
                    
                    while (tempX % prime == 0) {
                        powerX++;
                        tempX /= prime;
                    }
                    while (tempY % prime == 0) {
                        powerY++;
                        tempY /= prime;
                    }
                    
                    if (powerX > 0 || powerY > 0) {
                        isCursed = true;
                        break;
                    }
                }
                
                if (isCursed) cursedPairs++;
            }
        }
        
        System.out.println(cursedPairs);
        input.close();
    }
}
