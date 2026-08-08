#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n, q;
    cin >> n >> q;
    vector<long long> p(n + 1);
    for (int i = 1; i <= n; i++) {
        int a;
        cin >> a;
        p[i] = p[i - 1] + a;
    }
    long long t = p[n];
    while (q--) {
        long long x;
        cin >> x;
        x = (x - 1) % t + 1;
        cout << (lower_bound(p.begin() + 1, p.end(), x) - p.begin()) << '\n';
    }
    return 0;
}