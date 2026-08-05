
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