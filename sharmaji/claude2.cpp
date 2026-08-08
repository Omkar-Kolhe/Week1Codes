#include <iostream>
#include <vector>
using namespace std;

int findValue(vector<long long>& pref, long long r) {
    int lo = 0, hi = pref.size() - 1;
    while (lo < hi) {
        int mid = (lo + hi) / 2;
        if (pref[mid] < r)
            lo = mid + 1;
        else
            hi = mid;
    }
    return lo + 1;
}

int main() {
    int n, q;
    cin >> n >> q;

    vector<long long> pref(n);
    long long total = 0;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        total += a;
        pref[i] = total;
    }

    for (int i = 0; i < q; i++) {
        long long x;
        cin >> x;
        long long r = (x - 1) % total + 1;
        cout << findValue(pref, r) << "\n";
    }
    return 0;
}