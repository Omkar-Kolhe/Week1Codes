#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    long long totalMilk = 0;   // using long long to safely hold large sums
    int milkInGlass;

    // Read each glass and accumulate the total milk
    for (int i = 0; i < n; i++) {
        cin >> milkInGlass;
        totalMilk += milkInGlass;
    }

    // Check if we can distribute milk equally
    if (totalMilk % n == 0) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    return 0;
}