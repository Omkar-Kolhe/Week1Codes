#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, Q;
    cin >> N >> Q;

    vector<long long> pref(N);
    long long total = 0;

    for (int i = 0; i < N; ++i) {
        long long x;
        cin >> x;
        total += x;
        pref[i] = total;
    }

    while (Q--) {
        long long X;
        cin >> X;

        long long pos = (X - 1) % total + 1;
        int idx = lower_bound(pref.begin(), pref.end(), pos) - pref.begin();

        cout << idx + 1 << '\n';
    }

    return 0;
}