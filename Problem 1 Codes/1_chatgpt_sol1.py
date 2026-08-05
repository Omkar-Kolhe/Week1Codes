t = int(input())

for _ in range(t):
    n, x = map(int, input().split())
    a = list(map(int, input().split()))

    first = a[0]
    values = set(a)

    left = min(first, x)
    right = max(first, x)

    possible = True

    for rank in range(left, right + 1):
        if rank not in values:
            possible = False
            break

    if possible:
        print("YES")
    else:
        print("NO")