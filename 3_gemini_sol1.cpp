#include <iostream>

using namespace std;

long long get_gcd(long long a, long long b) {
    while (b) {
        long long temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    long long M;
    if (cin >> M) {
        long long temp = M;
        long long rad = 1;
        
        for (long long i = 2; i * i <= temp; ++i) {
            if (temp % i == 0) {
                rad *= i;
                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }
        if (temp > 1) {
            rad *= temp;
        }

        long long count = 0;
        for (long long x = 1; x < M; ++x) {
            long long g = get_gcd(x, rad);
            long long req = rad / g;
            count += (M - 1) / req;
        }
        
        cout << count << "\n";
    }
    return 0;
}
