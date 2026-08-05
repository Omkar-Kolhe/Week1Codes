from functools import lru_cache

M = int(input())

fac = []
t = M
p = 2
while p * p <= t:
    if t % p == 0:
        c = 0
        while t % p == 0:
            t //= p
            c += 1
        fac.append((p, c))
    p += 1

if t > 1:
    fac.append((t, 1))

k = len(fac)

mult = []
states = 1
for _, e in fac:
    mult.append(states)
    states *= (e + 1)

vec = [[0] * k for _ in range(states)]

for s in range(states):
    x = s
    for i, (_, e) in enumerate(fac):
        vec[s][i] = x % (e + 1)
        x //= (e + 1)


def encode(v):
    res = 0
    for i in range(k):
        res += v[i] * mult[i]
    return res


FULL = states - 1

add = [[0] * states for _ in range(states)]

for a in range(states):
    for b in range(states):
        c = [
            min(fac[i][1], vec[a][i] + vec[b][i])
            for i in range(k)
        ]
        add[a][b] = encode(c)

state = [0] * M

for v in range(1, M):
    x = v
    c = [0] * k
    for i, (prime, _) in enumerate(fac):
        while x % prime == 0:
            c[i] += 1
            x //= prime
    state[v] = encode(c)


@lru_cache(None)
def solve(A, B):
    C = add[A][B]
    if C == FULL:
        return True
    if C == B:
        return False
    return solve(B, C)


ans = 0

for x in range(1, M):
    for y in range(1, M):
        if solve(state[x], state[y]):
            ans += 1

print(ans)
