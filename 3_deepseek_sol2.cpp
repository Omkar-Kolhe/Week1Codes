#include <bits/stdc++.h>
using namespace std;

int main() {
    int M;
    cin >> M;
    
    vector<int> primeFactors;
    int n = M;
    for (int p = 2; p * p <= n; p++) {
        if (n % p == 0) {
            primeFactors.push_back(p);
            while (n % p == 0) n /= p;
        }
    }
    if (n > 1) primeFactors.push_back(n);
    
    int cursedPairs = 0;
    
    for (int x = 1; x < M; x++) {
        for (int y = 1; y < M; y++) {
            bool isCursed = false;
            
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
    
    cout << cursedPairs << endl;
    return 0;
}
