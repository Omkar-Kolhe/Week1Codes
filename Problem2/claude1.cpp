#include <bits/stdc++.h>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    vector<long long> a(n);
    long long sum = 0;
    for (int i = 0; i < n; i++){
        scanf("%lld", &a[i]);
        sum += a[i];
    }
    if (sum % n == 0) printf("YES\n");
    else printf("NO\n");
    return 0;
}