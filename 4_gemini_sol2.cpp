#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int main() {
    int n;
    if (cin >> n) {
        vector<long long> milk_glasses(n);
        
        // Read all inputs into the vector
        for (int i = 0; i < n; i++) {
            cin >> milk_glasses[i];
        }

        // 0LL ensures the sum is accumulated as a 64-bit integer
        long long total_milk = accumulate(milk_glasses.begin(), milk_glasses.end(), 0LL);

        // Ternary operator for concise output
        cout << (total_milk % n == 0 ? "YES\n" : "NO\n");
    }
    return 0;
}
