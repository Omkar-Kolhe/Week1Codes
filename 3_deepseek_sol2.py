import sys

def find_prime_factors(num):
    factors = []
    n = num
    p = 2
    while p * p <= n:
        if n % p == 0:
            factors.append(p)
            while n % p == 0:
                n //= p
        p += 1
    if n > 1:
        factors.append(n)
    return factors

def main():
    M = int(sys.stdin.readline())
    
    prime_factors = find_prime_factors(M)
    cursed_pairs = 0
    
    for x in range(1, M):
        for y in range(1, M):
            is_cursed = False
            
            for prime in prime_factors:
                power_x = 0
                power_y = 0
                temp_x = x
                temp_y = y
                
                while temp_x % prime == 0:
                    power_x += 1
                    temp_x //= prime
                
                while temp_y % prime == 0:
                    power_y += 1
                    temp_y //= prime
                
                if power_x > 0 or power_y > 0:
                    is_cursed = True
                    break
            
            if is_cursed:
                cursed_pairs += 1
    
    print(cursed_pairs)

if __name__ == "__main__":
    main()
