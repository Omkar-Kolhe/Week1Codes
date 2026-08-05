import sys

def solve():
    # Read all inputs from standard input
    input_data = sys.stdin.read().split()
    
    if not input_data:
        return
        
    n = int(input_data[0])
    
    # Calculate the total sum of the array
    # input_data[1:] contains the elements of the array
    total_sum = sum(int(x) for x in input_data[1:])
    
    # If the sum is divisible by n, it's possible to equalize
    if total_sum % n == 0:
        print("YES")
    else:
        print("NO")

if __name__ == '__main__':
    solve()