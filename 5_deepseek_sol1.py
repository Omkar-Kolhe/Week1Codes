MOD = 998244353
T = int(input())
for _ in range(T):
    N = int(input())
    A = input().split()
    A.sort(key=lambda x: x * 10, reverse=True)
    s = ''.join(A)
    ans = 0
    for ch in s:
        ans = (ans * 10 + ord(ch) - 48) % MOD
    print(ans)
