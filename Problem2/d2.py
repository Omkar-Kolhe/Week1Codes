# Read number of glasses
n = int(input())

# Read the amount of milk in each glass
glasses = list(map(int, input().split()))

# Calculate total milk
total_milk = sum(glasses)

# Can we make all glasses equal?
if total_milk % n == 0:
    print("YES")
else:
    print("NO")