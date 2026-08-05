#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int t;
    if (!(cin >> t)) return 0;
    
    while (t--) {
        int n;
        cin >> n;
        vector<string> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        
        sort(a.begin(), a.end(), [](const string& x, const string& y) {
            return x + y > y + x;
        });
        
        long long ans = 0;
        long long mod = 998244353;
        
        for (const string& s : a) {
            long long p = 1;
            long long val = 0;
            for (char c : s) {
                p = (p * 10) % mod;
                val = (val * 10 + (c - '0')) % mod;
            }
            ans = (ans * p % mod + val) % mod;
        }
        
        cout << ans << "\n";
    }
    
    return 0;
}
