import sys

def solve():
    # Reads the entire input buffer at once and splits by whitespace
    tokens = sys.stdin.read().split()
    if not tokens:
        return
        
    n = int(tokens[0])
    
    # Generator expression iterates through the sliced tokens without 
    # building a second list in memory
    total_milk = sum(int(x) for x in tokens[1:n+1])
    
    # Inline if-else for cleaner output
    print("YES" if total_milk % n == 0 else "NO")

if __name__ == '__main__':
    solve()
