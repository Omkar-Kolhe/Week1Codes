from functools import cmp_to_key

MOD = 998244353


def cmp(a, b):
    if a + b > b + a:
        return -1
    if a + b < b + a:
        return 1
    return 0


def mod_pow10(length):
    res = 1
    base = 10

    while length:
        if length & 1:
            res = (res * base) % MOD
        base = (base * base) % MOD
        length >>= 1

    return res


t = int(input())

for _ in range(t):
    n = int(input())

    arr = input().split()

    arr.sort(key=cmp_to_key(cmp))

    ans = 0

    for s in arr:
        val = 0
        for ch in s:
            val = (val * 10 + int(ch)) % MOD

        ans = (ans * mod_pow10(len(s))) % MOD
        ans = (ans + val) % MOD

    print(ans)
