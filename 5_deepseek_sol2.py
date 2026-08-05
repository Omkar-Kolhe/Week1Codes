MOD = 998244353

T = int(input())

for _ in range(T):
    N = int(input())
    numbers = input().split()
    
    from functools import cmp_to_key
    
    def compare(a, b):
        if a + b > b + a:
            return -1
        elif a + b < b + a:
            return 1
        else:
            return 0
    
    numbers.sort(key=cmp_to_key(compare))
    
    final_number = ''.join(numbers)
    
    answer = 0
    for digit_char in final_number:
        digit = int(digit_char)
        answer = (answer * 10 + digit) % MOD
    
    print(answer)
