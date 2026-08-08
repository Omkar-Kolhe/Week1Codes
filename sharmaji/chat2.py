import sys
from bisect import bisect_left

input_data = list(map(int, sys.stdin.buffer.read().split()))

n = input_data[0]
q = input_data[1]

a = input_data[2:n + 2]

prefix = []
length = 0

for value in a:
    length += value
    prefix.append(length)

result = []

for i in range(q):
    x = input_data[n + 2 + i]
    x = (x - 1) % length + 1

    index = bisect_left(prefix, x)
    result.append(str(index + 1))

print("\n".join(result))