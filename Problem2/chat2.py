n = int(input())

milk = list(map(int, input().split()))

total = sum(milk)

if total % n == 0:
    print("YES")
else:
    print("NO")