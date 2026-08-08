import sys

def solve():
    MOD = 998244353
    input_data = sys.stdin.read().split()
    idx = 0
    t = int(input_data[idx]); idx += 1
    out = []
    for _ in range(t):
        n = int(input_data[idx]); idx += 1
        arr = input_data[idx:idx+n]; idx += n
        arr.sort(key=lambda x: x*20, reverse=True)
        res = 0
        for x in arr:
            res = (res * pow(10, len(x), MOD) + int(x) % MOD) % MOD
        out.append(str(res))
    print('\n'.join(out))

solve()
