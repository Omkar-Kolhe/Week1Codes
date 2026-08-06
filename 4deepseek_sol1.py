n = int(input())
arr = list(map(int, input().split()))
total = sum(arr)
print("YES" if total % n == 0 else "NO")
