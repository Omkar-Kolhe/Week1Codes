#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    long long totalMilk = 0;   
    int milkInGlass;

    
    for (int i = 0; i < n; i++) {
        cin >> milkInGlass;
        totalMilk += milkInGlass;
    }

    if (totalMilk % n == 0) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }

    return 0;
}