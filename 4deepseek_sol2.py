from functools import reduce

n = int(input())
arr = list(map(int, input().split()))
total = reduce(lambda x, y: x + y, arr)
print("YES" if total % n == 0 else "NO")
