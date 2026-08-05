#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    

    vector<int> nums(n);
    

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