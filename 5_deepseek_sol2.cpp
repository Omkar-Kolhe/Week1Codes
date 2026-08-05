#include <bits/stdc++.h>
using namespace std;

const int MOD = 998244353;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    
    int T;
    cin >> T;
    
    while (T--) {
        int N;
        cin >> N;
        
        vector<string> numbers(N);
        for (int i = 0; i < N; i++) {
            cin >> numbers[i];
        }
        
        sort(numbers.begin(), numbers.end(), [](string &a, string &b) {
            return (a + b) > (b + a);
        });
        
        string concatenated = "";
        for (string &num : numbers) {
            concatenated += num;
        }
        
        long long answer = 0;
        for (char ch : concatenated) {
            int digit = ch - '0';
            answer = (answer * 10 + digit) % MOD;
        }
        
        cout << answer << "\n";
    }
    
    return 0;
}
