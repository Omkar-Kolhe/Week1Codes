from functools import cmp_to_key

MOD = 998244353


def compare(first, second):
    if first + second > second + first:
        return -1
    if first + second < second + first:
        return 1
    return 0


def power_of_ten(digits):
    result = 1
    base = 10

    while digits:
        if digits & 1:
            result = (result * base) % MOD

        base = (base * base) % MOD
        digits >>= 1

    return result


test_cases = int(input())

for _ in range(test_cases):
    size = int(input())

    numbers = input().split()

    numbers.sort(key=cmp_to_key(compare))

    answer = 0

    for current in numbers:
        current_value = 0

        for digit in current:
            current_value = (current_value * 10 + int(digit)) % MOD

        answer = (answer * power_of_ten(len(current))) % MOD
        answer = (answer + current_value) % MOD

    print(answer)
