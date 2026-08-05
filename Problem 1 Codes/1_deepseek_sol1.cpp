#include <bits/stdc++.h>
using namespace std;

void solve()
{
    int n, x;
    cin >> n >> x;
    vector<int> a(n);
    int pos = -1;
    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];
        if (a[i] == x)
            pos = i;
    }

    int mn = INT_MAX, mx = INT_MIN;
    for (int i = 0; i <= pos; ++i)
    {
        mn = min(mn, a[i]);
        mx = max(mx, a[i]);
    }

    if (mx - mn + 1 == pos + 1)
        cout << "YES\n";
    else
        cout << "NO\n";
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