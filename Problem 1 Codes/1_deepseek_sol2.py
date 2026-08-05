import sys


def solve():
    input_data = sys.stdin.buffer.read().split()
    t = int(input_data[0])
    idx = 1
    out = []

    for _ in range(t):
        n = int(input_data[idx])
        x = int(input_data[idx + 1])
        idx += 2

        a = input_data[idx:idx + n]
        idx += n

        # Convert to integers and find position of X
        arr = [int(v) for v in a]
        pos = arr.index(x)

        # Collect prefix elements into a set
        prefix_set = set()
        min_val = 10**18
        max_val = -10**18

        for i in range(pos + 1):
            val = arr[i]
            prefix_set.add(val)
            if val < min_val:
                min_val = val
            if val > max_val:
                max_val = val

        # Check contiguity: all integers from min_val to max_val must be present
        # Since all values are distinct, this is equivalent to:
        # max_val - min_val + 1 == size of prefix_set
        if max_val - min_val + 1 == len(prefix_set) == pos + 1:
            out.append("YES")
        else:
            out.append("NO")

    sys.stdout.write("\n".join(out))


if __name__ == "__main__":
    solve()
