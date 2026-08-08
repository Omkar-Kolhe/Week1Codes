import sys
import bisect

def solve():
    data = sys.stdin.buffer.read().split()
    it = iter(data)
    array_length = int(next(it))
    query_count = int(next(it))
    prefix_sum = [0] * (array_length + 1)
    for i in range(1, array_length + 1):
        frequency = int(next(it))
        prefix_sum[i] = prefix_sum[i - 1] + frequency
    sequence_length = prefix_sum[array_length]
    out = []
    for _ in range(query_count):
        target_index = int(next(it))
        position = (target_index - 1) % sequence_length + 1
        answer = bisect.bisect_left(prefix_sum, position)
        out.append(str(answer))
    sys.stdout.write('\n'.join(out))

if __name__ == '__main__':
    solve()