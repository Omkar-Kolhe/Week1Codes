def can_reach_front(arr, target):
    front = arr[0]

    if front == target:
        return True

    ordered = sorted(arr)

    front_index = ordered.index(front)
    target_index = ordered.index(target)

    start = min(front_index, target_index)
    end = max(front_index, target_index)

    for i in range(start, end):
        if ordered[i + 1] - ordered[i] != 1:
            return False

    return True


tests = int(input())

while tests > 0:
    n, x = map(int, input().split())
    ranks = list(map(int, input().split()))

    print("YES" if can_reach_front(ranks, x) else "NO")

    tests -= 1
