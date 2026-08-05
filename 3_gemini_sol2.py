import sys
import math

def count_cursed_pairs():
    input_content = sys.stdin.read().split()
    if not input_content:
        return
        
    modulus = int(input_content[0])
    
    remaining_value = modulus
    square_free_product = 1
    current_divisor = 2
    
    while current_divisor * current_divisor <= remaining_value:
        if remaining_value % current_divisor == 0:
            square_free_product *= current_divisor
            while remaining_value % current_divisor == 0:
                remaining_value //= current_divisor
        current_divisor += 1
        
    if remaining_value > 1:
        square_free_product *= remaining_value
        
    cursed_pair_count = 0
    for start_x in range(1, modulus):
        current_gcd = math.gcd(start_x, square_free_product)
        required_y_factor = square_free_product // current_gcd
        cursed_pair_count += (modulus - 1) // required_y_factor
        
    print(cursed_pair_count)

if __name__ == '__main__':
    count_cursed_pairs()
