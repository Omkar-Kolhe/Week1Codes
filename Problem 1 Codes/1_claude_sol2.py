
import sys


def find_range_bounds(target, value_set):
    lo = target
    hi = target
    while (lo - 1) in value_set:
        lo -= 1
    while (hi + 1) in value_set:
        hi += 1
    return lo, hi


def solve_case(n, x, queue):
    value_set = set(queue)
    lo, hi = find_range_bounds(x, value_set)
    front_val = queue[0]
    return "YES" if lo <= front_val <= hi else "NO"


def main():
    input_data = sys.stdin.read().split()
    pos = 0
    t = int(input_data[pos])
    pos += 1

    output_lines = []
    for _ in range(t):
        n = int(input_data[pos])
        x = int(input_data[pos + 1])
        pos += 2

        queue = list(map(int, input_data[pos: pos + n]))
        pos += n

        output_lines.append(solve_case(n, x, queue))

    print("\n".join(output_lines))


if __name__ == "__main__":
    main()
