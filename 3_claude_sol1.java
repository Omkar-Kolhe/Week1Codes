import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        List<Integer> primes = new ArrayList<>();
        int m = M;
        for(int p = 2; (long)p * p <= m; p++){
            if(m % p == 0){
                primes.add(p);
                while(m % p == 0) m /= p;
            }
        }
        if(m > 1) primes.add(m);

        long count = 0;
        for(int x = 1; x <= M - 1; x++){
            for(int y = 1; y <= M - 1; y++){
                boolean ok = true;
                for(int p : primes){
                    if(x % p != 0 && y % p != 0){
                        ok = false;
                        break;
                    }
                }
                if(ok) count++;
            }
        }
        System.out.println(count);
    }
}
