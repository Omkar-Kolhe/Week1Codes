
n = int(input())


glasses = list(map(int, input().split()))


total_milk = sum(glasses)


if total_milk % n == 0:
    print("YES")
else:
    print("NO")