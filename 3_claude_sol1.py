def main():
    M = int(input())
    m = M
    primes = []
    p = 2
    while p * p <= m:
        if m % p == 0:
            primes.append(p)
            while m % p == 0:
                m //= p
        p += 1
    if m > 1:
        primes.append(m)

    count = 0
    for x in range(1, M):
        for y in range(1, M):
            ok = True
            for p in primes:
                if x % p != 0 and y % p != 0:
                    ok = False
                    break
            if ok:
                count += 1
    print(count)

main()
