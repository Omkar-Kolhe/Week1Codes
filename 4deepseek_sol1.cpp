#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    long long sum = 0;
    for (int i = 0; i < n; i++) {
        long long x;
        cin >> x;
        sum += x;
    }
    if (sum % n == 0)
        cout << "YES\n";
    else
        cout << "NO\n";
    return 0;
}
