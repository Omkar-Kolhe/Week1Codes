#include <iostream>

using namespace std;

int main() {
    // Fast I/O
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    if (cin >> n) {
        long long total_milk = 0;
        for (int i = 0; i < n; i++) {
            long long a;
            cin >> a;
            total_milk += a; // Process on the fly
        }

        if (total_milk % n == 0) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}
