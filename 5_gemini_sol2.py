from functools import cmp_to_key

def custom_compare(first, second):
    if first + second > second + first:
        return -1
    elif first + second < second + first:
        return 1
    else:
        return 0

def main():
    try:
        test_cases = int(input())
    except EOFError:
        return
        
    modulo_value = 998244353
    
    for _ in range(test_cases):
        array_size = int(input())
        numbers = input().split()
        
        numbers.sort(key=cmp_to_key(custom_compare))
        
        final_result = 0
        for number_str in numbers:
            length = len(number_str)
            multiplier = pow(10, length, modulo_value)
            integer_value = int(number_str) % modulo_value
            
            final_result = (final_result * multiplier + integer_value) % modulo_value
            
        print(final_result)

if __name__ == '__main__':
    main()
