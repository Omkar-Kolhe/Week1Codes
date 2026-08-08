import sys

def find_index(prefix, r):
    lo, hi = 0, len(prefix) - 1
    while lo < hi:
        mid = (lo + hi) // 2
        if prefix[mid] < r:
            lo = mid + 1
        else:
            hi = mid
    return lo + 1

def main():
    input_data = sys.stdin.read().split()
    pos = 0

    n = int(input_data[pos]); pos += 1
    q = int(input_data[pos]); pos += 1

    prefix = []
    total = 0
    for i in range(n):
        a = int(input_data[pos]); pos += 1
        total += a
        prefix.append(total)

    results = []
    for i in range(q):
        x = int(input_data[pos]); pos += 1
        r = (x - 1) % total + 1
        results.append(find_index(prefix, r))

    print("\n".join(map(str, results)))

main()