#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    long long totalMilk = 0;

    for (int i = 0; i < n; i++) {
        long long amount;
        cin >> amount;
        totalMilk += amount;
    }

    if (totalMilk % n == 0) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}