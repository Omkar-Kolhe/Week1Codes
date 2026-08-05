import sys


def solve():
    # Read all tokens from standard input for fast I/O
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

        # Extract the array for the current testcase
        A = [int(x) for x in input_data[idx: idx+N]]
        idx += N

        first_element = A[0]

        # If Champak is already at the front
        if first_element == X:
            results.append("YES")
            continue

        low = min(first_element, X)
        high = max(first_element, X)
        required_length = high - low + 1

        # If the gap is larger than the array size, it's immediately impossible
        if required_length > N:
            results.append("NO")
            continue

        # Count how many elements are within the required [low, high] bounds
        present = sum(1 for val in A if low <= val <= high)

        # If the count matches the required sequence length, no numbers are missing
        if present == required_length:
            results.append("YES")
        else:
            results.append("NO")

    # Print all results separated by a newline
    sys.stdout.write('\n'.join(results) + '\n')


if __name__ == '__main__':
    solve()
