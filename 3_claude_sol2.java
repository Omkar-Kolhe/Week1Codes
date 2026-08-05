import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        int temp = m;
        ArrayList<Integer> pf = new ArrayList<>();
        for (int i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                pf.add(i);
                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }
        if (temp > 1) {
            pf.add(temp);
        }

        long ans = 0;
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < m; y++) {
                boolean cursed = true;
                for (int i = 0; i < pf.size(); i++) {
                    int p = pf.get(i);
                    if (x % p != 0 && y % p != 0) {
                        cursed = false;
                        break;
                    }
                }
                if (cursed) {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
