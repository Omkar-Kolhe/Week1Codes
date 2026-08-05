#include <bits/stdc++.h>
using namespace std;

int main() {
    int M;
    cin >> M;
    
    vector<int> primeFactors;
    int temp = M;
    for (int p = 2; p * p <= temp; p++) {
        if (temp % p == 0) {
            primeFactors.push_back(p);
            while (temp % p == 0) temp /= p;
        }
    }
    if (temp > 1) primeFactors.push_back(temp);
    
    int count = 0;
    for (int x = 1; x <= M - 1; x++) {
        for (int y = 1; y <= M - 1; y++) {
            bool cursed = false;
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
    
    cout << count << endl;
    return 0;
}
