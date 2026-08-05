def main():
    # Read the number of glasses
    n = int(input())
    
    # Read the milk amounts into a list
    nums = list(map(int, input().split()))
    
    # Python automatically handles huge numbers, so we just sum the list
    total_sum = sum(nums)
    
    # Check if the total can be evenly divided
    if total_sum % n == 0:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()