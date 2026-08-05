n = int(input())
a = list(map(int, input().split()))
if sum(a) % n == 0:
    print("YES")
else:
    print("NO")