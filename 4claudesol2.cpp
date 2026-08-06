#include <cstdio>

int main() {
    int n;
    scanf("%d", &n);
    
    long long sum = 0;
    for (int i = 0; i < n; i++) {
        long long x;
        scanf("%lld", &x);
        sum += x;
    }
    
    printf("%s\n", (sum % n == 0) ? "YES" : "NO");
    return 0;
}
