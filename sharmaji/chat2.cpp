#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, q;
    cin >> n >> q;

    vector<long long> prefix(n);
    long long length = 0;

    for (int i = 0; i < n; i++) {
        long long a;
        cin >> a;
        length += a;
        prefix[i] = length;
    }

    while (q--) {
        long long x;
        cin >> x;

        x = (x - 1) % length + 1;

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= x)
                right = mid;
            else
                left = mid + 1;
        }

        cout << left + 1 << '\n';
    }

    return 0;
}