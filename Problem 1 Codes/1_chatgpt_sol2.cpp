#include <bits/stdc++.h>
using namespace std;

bool canMoveToFront(vector<long long> arr, long long x)
{
    long long front = arr[0];

    if (front == x)
        return true;

    sort(arr.begin(), arr.end());

    int frontPos = -1;
    int targetPos = -1;

    for (int i = 0; i < (int)arr.size(); i++)
    {
        if (arr[i] == front)
            frontPos = i;

        if (arr[i] == x)
            targetPos = i;
    }

    int left = min(frontPos, targetPos);
    int right = max(frontPos, targetPos);

    for (int i = left; i < right; i++)
    {
        if (arr[i + 1] - arr[i] != 1)
            return false;
    }

    return true;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--)
    {
        int N;
        long long X;

        cin >> N >> X;

        vector<long long> A(N);

        for (auto &value : A)
            cin >> value;

        if (canMoveToFront(A, X))
            cout << "YES\n";
        else
            cout << "NO\n";
    }

    return 0;
}