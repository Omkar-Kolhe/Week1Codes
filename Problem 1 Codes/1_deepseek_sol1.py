import sys


def solve():
    data = sys.stdin.read().split()
    it = iter(data)
    t = int(next(it))
    out_lines = []

    for _ in range(t):
        n = int(next(it))
        x = int(next(it))
        a = [int(next(it)) for _ in range(n)]

   
        pos = a.index(x)

   
        min_val = float('inf')
        max_val = float('-inf')
        for i in range(pos + 1):
            if a[i] < min_val:
                min_val = a[i]
            if a[i] > max_val:
                max_val = a[i]

        if max_val - min_val + 1 == pos + 1:
            out_lines.append("YES")
        else:
            out_lines.append("NO")

    sys.stdout.write("\n".join(out_lines))


if __name__ == "__main__":
    solve()
