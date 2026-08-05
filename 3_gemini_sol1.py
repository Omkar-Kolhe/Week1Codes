import sys
import math

def solve():
    input_data = sys.stdin.read().split()
    if not input_data:
        return
    M = int(input_data[0])
    
    temp = M
    rad = 1
    i = 2
    
    while i * i <= temp:
        if temp % i == 0:
            rad *= i
            while temp % i == 0:
                temp //= i
        i += 1
        
    if temp > 1:
        rad *= temp
        
    count = 0
    for x in range(1, M):
        g = math.gcd(x, rad)
        req = rad // g
        count += (M - 1) // req
        
    print(count)

if __name__ == '__main__':
    solve()
