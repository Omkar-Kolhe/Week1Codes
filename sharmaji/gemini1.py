import sys
import bisect

def solve():
    input_data = sys.stdin.read().split()
    if not input_data: return
    n, q = int(input_data[0]), int(input_data[1])
    p = []
    s = 0
    for i in range(n):
        s += int(input_data[2+i])
        p.append(s)
    res = []
    for i in range(q):
        x = int(input_data[2+n+i])
        rem = (x-1) % s + 1
        res.append(str(bisect.bisect_left(p, rem) + 1))
    sys.stdout.write('\n'.join(res) + '\n')

solve()