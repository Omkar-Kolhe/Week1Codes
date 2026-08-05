import sys
import math

def get_prime_factors(n):
    factors = []
    temp = n
    p = 2
    while p * p <= temp:
        if temp % p == 0:
            factors.append(p)
            while temp % p == 0:
                temp //= p
        p += 1
    if temp > 1:
        factors.append(temp)
    return factors

def main():
    M = int(sys.stdin.readline().strip())
    
    prime_factors = get_prime_factors(M)
    
    count = 0
    for x in range(1, M):
        for y in range(1, M):
            cursed = False
            for p in prime_factors:
                exp_x = 0
                exp_y = 0
                tx, ty = x, y
                while tx % p == 0:
                    exp_x += 1
                    tx //= p
                while ty % p == 0:
                    exp_y += 1
                    ty //= p
                
                if exp_x == 0 and exp_y == 0:
                    continue
                if exp_x > 0 or exp_y > 0:
                    cursed = True
                    break
            
            if cursed:
                count += 1
    
    print(count)

if __name__ == "__main__":
    main()
