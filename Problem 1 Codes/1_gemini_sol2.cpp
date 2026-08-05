#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void run_case()
{
    int n;
    long long target;
    cin >> n >> target;

    vector<long long> arr(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> arr[i];
    }

    long long first_element = arr[0];

    if (first_element == target)
    {
        cout << "YES\n";
        return;
    }

    sort(arr.begin(), arr.end());

    long long min_val = min(first_element, target);
    long long max_val = max(first_element, target);

    
    auto it_min = lower_bound(arr.begin(), arr.end(), min_val);
    auto it_max = lower_bound(arr.begin(), arr.end(), max_val);

    long long index_difference = distance(it_min, it_max);
    long long value_difference = max_val - min_val;

    if (index_difference == value_difference)
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

    int tc;
    if (cin >> tc)
    {
        while (tc--)
        {
            run_case();
        }
    }
    return 0;
}