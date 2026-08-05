
#include <bits/stdc++.h>
using namespace std;

static bool canReachFront(long long frontVal, long long target,
                          unordered_set<long long> &values)
{
    long long lo = target, hi = target;
    while (values.find(lo - 1) != values.end())
        lo--;
    while (values.find(hi + 1) != values.end())
        hi++;
    return (frontVal >= lo && frontVal <= hi);
}

int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int N;
        long long X;
        scanf("%d %lld", &N, &X);

        vector<long long> queueArr(N);
        unordered_set<long long> present;
        present.reserve(N * 2);

        for (int i = 0; i < N; i++)
        {
            scanf("%lld", &queueArr[i]);
            present.insert(queueArr[i]);
        }

        bool result = canReachFront(queueArr[0], X, present);
        printf("%s\n", result ? "YES" : "NO");
    }
    return 0;
}