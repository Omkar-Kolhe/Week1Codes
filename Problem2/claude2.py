n = int(input())
nums = list(map(int, input().split()))
total = sum(nums)  # Python ints don't overflow, so no worries here

if total % n == 0:
    print("YES")
else:
    print("NO")