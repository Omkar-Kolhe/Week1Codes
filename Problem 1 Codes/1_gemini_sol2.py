import sys
import bisect


def main():

    lines = sys.stdin.read().split()
    if not lines:
        return

    t = int(lines[0])
    ptr = 1

    output = []
    for _ in range(t):
        n = int(lines[ptr])
        target_x = int(lines[ptr+1])
        ptr += 2

        arr = []
        for i in range(n):
            arr.append(int(lines[ptr + i]))
        ptr += n

        initial_val = arr[0]

        if initial_val == target_x:
            output.append("YES")
            continue

        arr.sort()

     
        pos1 = bisect.bisect_left(arr, initial_val)
        pos2 = bisect.bisect_left(arr, target_x)


        index_diff = abs(pos1 - pos2)
        value_diff = abs(initial_val - target_x)


        if index_diff == value_diff:
            output.append("YES")
        else:
            output.append("NO")

    sys.stdout.write("\n".join(output) + "\n")


if __name__ == '__main__':
    main()
