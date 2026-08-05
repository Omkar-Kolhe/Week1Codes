#include <iostream>

using namespace std;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n;
    if (cin >> n) {
        long long total_sum = 0;
        for (int i = 0; i < n; i++) {
            long long a;
            cin >> a;
            total_sum += a;
        }
        
  
        if (total_sum % n == 0) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    
    return 0;
}