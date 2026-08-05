import sys
from functools import cmp_to_key

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    
    t = int(input_data[0])
    idx = 1
    mod = 998244353
    
    def compare(x, y):
        if x + y > y + x:
            return -1
        elif x + y < y + x:
            return 1
        else:
            return 0

    out = []
    for _ in range(t):
        n = int(input_data[idx])
        idx += 1
        a = input_data[idx : idx+n]
        idx += n
        
        a.sort(key=cmp_to_key(compare))
        
        ans = 0
        for s in a:
            ans = (ans * pow(10, len(s), mod) + int(s)) % mod
        out.append(str(ans))
        
    print('\n'.join(out))

if __name__ == '__main__':
    solve()
