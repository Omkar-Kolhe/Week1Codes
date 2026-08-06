#include <iostream>
#include <vector>
#include <numeric>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<long long> a(n);

    for (int i = 0; i < n; i++)
        cin >> a[i];

    long long total = accumulate(a.begin(), a.end(), 0LL);

    cout << (total % n == 0 ? "YES" : "NO");

    return 0;
}
