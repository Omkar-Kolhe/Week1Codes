import sys

def main():
    data = sys.stdin.read().split()
    n = int(data[0])
    a = list(map(int, data[1:1+n]))
    total = sum(a)
    print("YES" if total % n == 0 else "NO")

if __name__ == "__main__":
    main()