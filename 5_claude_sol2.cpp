#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long mod = 998244353;

    int testCases;
    cin >> testCases;

    while (testCases--) {
        int n;
        cin >> n;

        vector<string> nums(n);
        for (int i = 0; i < n; i++) {
            int val;
            cin >> val;
            nums[i] = to_string(val);
        }

        sort(nums.begin(), nums.end(), [](const string &a, const string &b) {
            return a + b > b + a;
        });

        long long answer = 0;
        for (int i = 0; i < n; i++) {
            long long power = 1;
            for (int j = 0; j < (int)nums[i].size(); j++) {
                power = (power * 10) % mod;
            }
            long long digitValue = stoll(nums[i]) % mod;
            answer = (answer * power + digitValue) % mod;
        }

        cout << answer << "\n";
    }

    return 0;
}
