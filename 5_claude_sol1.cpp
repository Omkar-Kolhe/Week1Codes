#include <bits/stdc++.h>
using namespace std;

const long long MOD = 998244353;

int main() {
    int T;
    scanf("%d", &T);
    while (T--) {
        int n;
        scanf("%d", &n);
        vector<string> a(n);
        for (int i = 0; i < n; i++) {
            int x;
            scanf("%d", &x);
            a[i] = to_string(x);
        }
        sort(a.begin(), a.end(), [](const string &x, const string &y) {
            return x + y > y + x;
        });
        long long res = 0;
        for (int i = 0; i < n; i++) {
            long long p10 = 1;
            for (size_t j = 0; j < a[i].size(); j++) p10 = (p10 * 10) % MOD;
            res = (res * p10 + (stoll(a[i]) % MOD)) % MOD;
        }
        printf("%lld\n", res);
    }
    return 0;
}
