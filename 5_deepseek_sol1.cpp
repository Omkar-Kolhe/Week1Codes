#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;
    while (T--) {
        int N;
        cin >> N;
        vector<string> A(N);
        for (int i = 0; i < N; i++) cin >> A[i];
        sort(A.begin(), A.end(), [](string &a, string &b) {
            return a + b > b + a;
        });
        string s;
        for (string &x : A) s += x;
        long long ans = 0;
        for (char c : s) {
            ans = (ans * 10 + (c - '0')) % MOD;
        }
        cout << ans << '\n';
    }
    return 0;
}
