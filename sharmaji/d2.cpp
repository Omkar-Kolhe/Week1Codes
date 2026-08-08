#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    int arrayLength, queryCount;
    cin >> arrayLength >> queryCount;
    vector<long long> prefixSum(arrayLength + 1);
    for (int i = 1; i <= arrayLength; ++i) {
        int frequency;
        cin >> frequency;
        prefixSum[i] = prefixSum[i - 1] + frequency;
    }
    long long sequenceLength = prefixSum[arrayLength];
    while (queryCount--) {
        long long targetIndex;
        cin >> targetIndex;
        long long position = (targetIndex - 1) % sequenceLength + 1;
        int answer = lower_bound(prefixSum.begin() + 1, prefixSum.end(), position) - prefixSum.begin();
        cout << answer << '\n';
    }
    return 0;
}