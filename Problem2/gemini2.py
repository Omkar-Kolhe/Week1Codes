def main():
   
    n = int(input())
    
   
    nums = list(map(int, input().split()))
    
  
    total_sum = sum(nums)
    
    
    if total_sum % n == 0:
        print("YES")
    else:
        print("NO")

if __name__ == "__main__":
    main()