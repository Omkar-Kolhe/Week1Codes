import sys

def solve():

    input_data = sys.stdin.read().split()
    
    if not input_data:
        return
        
    n = int(input_data[0])
    
    
    total_sum = sum(int(x) for x in input_data[1:])
    
    
    if total_sum % n == 0:
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    solve()