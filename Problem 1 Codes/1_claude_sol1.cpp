// Solution 1: Sort + block grouping (union of consecutive values via sorting)
#include <bits/stdc++.h>
using namespace std;

int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int N;
        long long X;
        scanf("%d %lld", &N, &X);

        vector<long long> arr(N);
        for (int i = 0; i < N; i++)
            scanf("%lld", &arr[i]);

        vector<long long> sortedVals = arr;
        sort(sortedVals.begin(), sortedVals.end());

        // Assign a block id to each distinct value: values that form a
        // contiguous run (difference of 1 between consecutive sorted
        // elements) belong to the same block, since within a block any
        // permutation is reachable via repeated adjacent-value swaps.
        unordered_map<long long, int> blockOf;
        blockOf.reserve(N * 2);

        int currentBlock = 0;
        blockOf[sortedVals[0]] = currentBlock;
        for (int i = 1; i < N; i++)
        {
            if (sortedVals[i] - sortedVals[i - 1] != 1)
            {
                currentBlock++;
            }
            blockOf[sortedVals[i]] = currentBlock;
        }

        int frontBlock = blockOf[arr[0]];
        int targetBlock = blockOf[X];

        puts(frontBlock == targetBlock ? "YES" : "NO");
    }
    return 0;
}