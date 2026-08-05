#include <iostream>
#include <vector>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N;
    cin >> N;

    long long sum = 0;
    for (int i = 0; i < N; i++) {
        long long x;
        cin >> x;
        sum += x;
    }

    cout << (sum % N == 0 ? "YES" : "NO") << '\n';

    return 0;
}