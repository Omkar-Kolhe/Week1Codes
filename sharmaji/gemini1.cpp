#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n, q;
    if (!(cin >> n >> q)) return 0;
    vector<long long> p(n);
    long long s = 0;
    for (int i = 0; i < n; ++i) {
        long long a;
        cin >> a;
        s += a;
        p[i] = s;
    }
    while (q--) {
        long long x;
        cin >> x;
        long long rem = (x - 1) % s + 1;
        auto it = lower_bound(p.begin(), p.end(), rem);
        cout << distance(p.begin(), it) + 1 << "\n";
    }
    return 0;
}