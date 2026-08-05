#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int n, x;
    cin >> n >> x;
    vector<int> a(n);
    int pos = 0;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
        if (a[i] == x)
            pos = i;
    }

    unordered_set<int> seen;
    int min_val = INT_MAX, max_val = INT_MIN;
    for (int i = 0; i <= pos; i++)
    {
        seen.insert(a[i]);
        min_val = min(min_val, a[i]);
        max_val = max(max_val, a[i]);
    }

    bool ok = true;
    if ((int)seen.size() != pos + 1)
        ok = false; // duplicates shouldn't happen
    else if (max_val - min_val + 1 != pos + 1)
        ok = false;

    cout << (ok ? "YES" : "NO") << "\n";
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--)
        solve();
    return 0;
}