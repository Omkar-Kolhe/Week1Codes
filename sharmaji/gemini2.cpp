#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int arraySize, numQueries;
    if (!(cin >> arraySize >> numQueries)) {
        return 0;
    }

    vector<long long> prefixSums(arraySize);
    long long totalSequenceLength = 0;

    for (int i = 0; i < arraySize; ++i) {
        long long frequency;
        cin >> frequency;
        totalSequenceLength += frequency;
        prefixSums[i] = totalSequenceLength;
    }

    for (int i = 0; i < numQueries; ++i) {
        long long targetIndex;
        cin >> targetIndex;

        long long effectiveIndex = (targetIndex - 1) % totalSequenceLength + 1;
        auto iterator = lower_bound(prefixSums.begin(), prefixSums.end(), effectiveIndex);
        int elementValue = distance(prefixSums.begin(), iterator) + 1;

        cout << elementValue << "\n";
    }

    return 0;
}