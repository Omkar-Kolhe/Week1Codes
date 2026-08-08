#include <bits/stdc++.h>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, q;
    cin >> n >> q;

    vector<long long> prefix(n);
    long long total = 0;

    for (int i = 0; i < n; i++) {
        long long a;
        cin >> a;
        total += a;
        prefix[i] = total;
    }

    while (q--) {
        long long x;
        cin >> x;
        long long r = (x - 1) % total + 1;
        int idx = lower_bound(prefix.begin(), prefix.end(), r) - prefix.begin();
        cout << idx + 1 << "\n";
    }

    return 0;
}