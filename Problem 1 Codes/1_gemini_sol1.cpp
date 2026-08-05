#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void solve_test_case()
{
    int n;
    long long x;
    cin >> n >> x;

    vector<long long> a(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> a[i];
    }

    long long start_val = a[0];


    if (start_val == x)
    {
        cout << "YES\n";
        return;
    }

    long long left_bound = min(start_val, x);
    long long right_bound = max(start_val, x);
    long long required_elements = right_bound - left_bound + 1;


    if (required_elements > n)
    {
        cout << "NO\n";
        return;
    }

    int present_count = 0;
    for (int i = 0; i < n; ++i)
    {
        if (a[i] >= left_bound && a[i] <= right_bound)
        {
            present_count++;
        }
    }


    if (present_count == required_elements)
    {
        cout << "YES\n";
    }
    else
    {
        cout << "NO\n";
    }
}

int main()
{
    
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    if (cin >> t)
    {
        while (t--)
        {
            solve_test_case();
        }
    }
    return 0;
}