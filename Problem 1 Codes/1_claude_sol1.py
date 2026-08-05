# Solution 1: Sort + block grouping (contiguous-value blocks via sorting)
import sys


def main():
    data = sys.stdin.buffer.read().split()
    idx = 0
    T = int(data[idx])
    idx += 1
    results = []

    for _ in range(T):
        N = int(data[idx])
        X = int(data[idx + 1])
        idx += 2
        arr = data[idx: idx + N]
        arr = [int(v) for v in arr]
        idx += N

        sorted_vals = sorted(arr)

        # Group values into blocks: consecutive sorted values differing
        # by exactly 1 belong to the same block, since within such a
        # block any target permutation is reachable through repeated
        # adjacent-value swaps.
        block_of = {}
        current_block = 0
        block_of[sorted_vals[0]] = current_block
        for i in range(1, N):
            if sorted_vals[i] - sorted_vals[i - 1] != 1:
                current_block += 1
            block_of[sorted_vals[i]] = current_block

        front_block = block_of[arr[0]]
        target_block = block_of[X]

        results.append("YES" if front_block == target_block else "NO")

    sys.stdout.write("\n".join(results) + "\n")


if __name__ == "__main__":
    main()
