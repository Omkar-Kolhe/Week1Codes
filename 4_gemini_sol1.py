def solve():
    n = int(input())
    
    # Map splits the string and converts to integers, sum adds them up
    total_milk = sum(map(int, input().split()))
    
    if total_milk % n == 0:
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    solve()
