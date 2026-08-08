#include <bits/stdc++.h>
using namespace std;

const long long MOD = 998244353;

long long powerOfTen(int digits) {
    long long result = 1;
    long long base = 10;

    while (digits > 0) {
        if (digits & 1)
            result = (result * base) % MOD;

        base = (base * base) % MOD;
        digits >>= 1;
    }

    return result;
}

bool shouldComeFirst(const string &first, const string &second) {
    return first + second > second + first;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int testCases;
    cin >> testCases;

    while (testCases--) {
        int size;
        cin >> size;

        vector<string> numbers(size);

        for (int i = 0; i < size; i++) {
            long long value;
            cin >> value;
            numbers[i] = to_string(value);
        }

        sort(numbers.begin(), numbers.end(), shouldComeFirst);

        long long answer = 0;

        for (string &current : numbers) {
            long long currentValue = 0;

            for (char digit : current)
                currentValue = (currentValue * 10 + (digit - '0')) % MOD;

            answer = (answer * powerOfTen(current.size())) % MOD;
            answer = (answer + currentValue) % MOD;
        }

        cout << answer << '\n';
    }

    return 0;
}
