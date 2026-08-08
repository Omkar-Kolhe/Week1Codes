import sys, bisect
d = sys.stdin.read().split()
n, q = int(d[0]), int(d[1])
p = [0] * (n + 1)
for i in range(n):
    p[i + 1] = p[i] + int(d[2 + i])
t = p[-1]
out = []
for j in range(q):
    x = int(d[2 + n + j])
    x = (x - 1) % t + 1
    out.append(str(bisect.bisect_left(p, x)))
sys.stdout.write('\n'.join(out))