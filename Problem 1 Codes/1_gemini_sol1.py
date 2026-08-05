import sys


def solve():

    input_data = sys.stdin.read().split()
    if not input_data:
        return

    T = int(input_data[0])
    idx = 1

    results = []
    for _ in range(T):
        N = int(input_data[idx])
        X = int(input_data[idx+1])
        idx += 2


        A = [int(x) for x in input_data[idx: idx+N]]
        idx += N

        first_element = A[0]

        if first_element == X:
            results.append("YES")
            continue

        low = min(first_element, X)
        high = max(first_element, X)
        required_length = high - low + 1

        if required_length > N:
            results.append("NO")
            continue

        present = sum(1 for val in A if low <= val <= high)

        if present == required_length:
            results.append("YES")
        else:
            results.append("NO")

    sys.stdout.write('\n'.join(results) + '\n')


if __name__ == '__main__':
    solve()
