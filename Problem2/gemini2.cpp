#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    
    // Using a standard vector just like the Java array
    vector<int> nums(n);
    
    // Use long long to handle large sums
    long long sum = 0;
    
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
        sum += nums[i];
    }
    
    if (sum % n == 0) {
        cout << "YES" << endl;
    } else {
        cout << "NO" << endl;
    }
    
    return 0;
}