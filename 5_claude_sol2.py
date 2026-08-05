def solve():
    mod = 998244353
    test_cases = int(input())

    results = []
    for _ in range(test_cases):
        n = int(input())
        numbers = input().split()

        numbers.sort(key=lambda x: x * 20, reverse=True)

        answer = 0
        for num in numbers:
            power = pow(10, len(num), mod)
            answer = (answer * power + int(num) % mod) % mod

        results.append(str(answer))

    print("\n".join(results))


solve()
