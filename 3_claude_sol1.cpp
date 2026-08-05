#include <bits/stdc++.h>
using namespace std;

int main(){
    int M;
    cin >> M;
    vector<int> primes;
    int m = M;
    for(int p = 2; (long long)p * p <= m; p++){
        if(m % p == 0){
            primes.push_back(p);
            while(m % p == 0) m /= p;
        }
    }
    if(m > 1) primes.push_back(m);

    long long count = 0;
    for(int x = 1; x <= M - 1; x++){
        for(int y = 1; y <= M - 1; y++){
            bool ok = true;
            for(int p : primes){
                if(x % p != 0 && y % p != 0){
                    ok = false;
                    break;
                }
            }
            if(ok) count++;
        }
    }
    cout << count << endl;
    return 0;
}
