from functools import lru_cache

M = int(input())

prime_factors = []
temp = M
divisor = 2

while divisor * divisor <= temp:
    if temp % divisor == 0:
        exponent = 0
        while temp % divisor == 0:
            temp //= divisor
            exponent += 1
        prime_factors.append((divisor, exponent))
    divisor += 1

if temp > 1:
    prime_factors.append((temp, 1))

factor_count = len(prime_factors)

state_multiplier = []
total_states = 1

for _, exponent in prime_factors:
    state_multiplier.append(total_states)
    total_states *= (exponent + 1)

state_values = [[0] * factor_count for _ in range(total_states)]

for state in range(total_states):
    value = state
    for i, (_, exponent) in enumerate(prime_factors):
        state_values[state][i] = value % (exponent + 1)
        value //= (exponent + 1)


def encode_state(exponents):
    state = 0
    for i in range(factor_count):
        state += exponents[i] * state_multiplier[i]
    return state


merged_state = [[0] * total_states for _ in range(total_states)]

for state_a in range(total_states):
    for state_b in range(total_states):
        combined = []

        for i in range(factor_count):
            combined.append(
                min(
                    prime_factors[i][1],
                    state_values[state_a][i] + state_values[state_b][i]
                )
            )

        merged_state[state_a][state_b] = encode_state(combined)

number_state = [0] * M

for number in range(1, M):
    value = number
    exponents = [0] * factor_count

    for i, (prime, _) in enumerate(prime_factors):
        while value % prime == 0:
            exponents[i] += 1
            value //= prime

    number_state[number] = encode_state(exponents)


@lru_cache(None)
def is_cursed(first_state, second_state):
    next_state = merged_state[first_state][second_state]

    if next_state == total_states - 1:
        return True

    if next_state == second_state:
        return False

    return is_cursed(second_state, next_state)


answer = 0

for x in range(1, M):
    for y in range(1, M):
        if is_cursed(number_state[x], number_state[y]):
            answer += 1

print(answer)
