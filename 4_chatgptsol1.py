n = int(input())
arr = list(map(int, input().split()))

if sum(arr) % n == 0:
    print("YES")
else:
    print("NO")
