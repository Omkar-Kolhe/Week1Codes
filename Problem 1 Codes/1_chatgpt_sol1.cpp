#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        int N;
        long long X;
        cin >> N >> X;

        vector<long long> A(N);
        unordered_set<long long> present;

        for (int i = 0; i < N; i++) {
            cin >> A[i];
            present.insert(A[i]);
        }

        long long start = A[0];
        long long low = min(start, X);
        long long high = max(start, X);

        bool possible = true;

        for (long long value = low; value <= high; value++) {
            if (present.find(value) == present.end()) {
                possible = false;
                break;
            }
        }

        cout << (possible ? "YES" : "NO") << '\n';
    }

    return 0;
}