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

    // If Champak is already at the front
    if (start_val == x)
    {
        cout << "YES\n";
        return;
    }

    long long left_bound = min(start_val, x);
    long long right_bound = max(start_val, x);
    long long required_elements = right_bound - left_bound + 1;

    // If the difference is larger than N, it's impossible to have all intermediate values
    if (required_elements > n)
    {
        cout << "NO\n";
        return;
    }

    // Count how many elements in the array fall into the [left_bound, right_bound] range
    int present_count = 0;
    for (int i = 0; i < n; ++i)
    {
        if (a[i] >= left_bound && a[i] <= right_bound)
        {
            present_count++;
        }
    }

    // If every integer in the range is present, they form a contiguous swap sequence
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
    // Fast I/O
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