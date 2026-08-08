import sys
import bisect

def main():
    input_data = sys.stdin.read().split()
    if not input_data:
        return

    array_size = int(input_data[0])
    num_queries = int(input_data[1])

    prefix_sums = []
    total_sequence_length = 0

    for i in range(array_size):
        frequency = int(input_data[2 + i])
        total_sequence_length += frequency
        prefix_sums.append(total_sequence_length)

    output_results = []

    for i in range(num_queries):
        target_index = int(input_data[2 + array_size + i])
        effective_index = (target_index - 1) % total_sequence_length + 1
        
        element_index = bisect.bisect_left(prefix_sums, effective_index)
        element_value = element_index + 1
        output_results.append(str(element_value))

    sys.stdout.write('\n'.join(output_results) + '\n')

if __name__ == '__main__':
    main()