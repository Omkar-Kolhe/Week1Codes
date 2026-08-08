import sys
from bisect import bisect_left

data = list(map(int, sys.stdin.buffer.read().split()))

n, q = data[0], data[1]
a = data[2:2 + n]
queries = data[2 + n:]

prefix = []
total = 0

for x in a:
    total += x
    prefix.append(total)

ans = []

for x in queries:
    pos = (x - 1) % total + 1
    idx = bisect_left(prefix, pos)
    ans.append(str(idx + 1))

sys.stdout.write("\n".join(ans))