#include <bits/stdc++.h>
using namespace std;

const long long MOD = 998244353;

bool cmp(const string &a, const string &b) {
    return a + b > b + a;
}

long long modPow10(int len) {
    long long res = 1;
    long long base = 10;

    while (len) {
        if (len & 1)
            res = (res * base) % MOD;
        base = (base * base) % MOD;
        len >>= 1;
    }

    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        vector<string> arr(N);

        for (int i = 0; i < N; i++) {
            long long x;
            cin >> x;
            arr[i] = to_string(x);
        }

        sort(arr.begin(), arr.end(), cmp);

        long long ans = 0;

        for (string &s : arr) {
            long long val = 0;
            for (char c : s)
                val = (val * 10 + (c - '0')) % MOD;

            ans = (ans * modPow10(s.size())) % MOD;
            ans = (ans + val) % MOD;
        }

        cout << ans << "\n";
    }

    return 0;
}
