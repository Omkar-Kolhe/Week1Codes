n = int(input())
nums = list(map(int, input().split()))
total = sum(nums)  

if total % n == 0:
    print("YES")
else:
    print("NO")