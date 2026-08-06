#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    long long sum = 0, x;

    for (int i = 0; i < n; i++) {
        cin >> x;
        sum += x;
    }

    if (sum % n == 0)
        cout << "YES";
    else
        cout << "NO";

    return 0;
}
