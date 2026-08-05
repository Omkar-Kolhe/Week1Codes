m = int(input())

temp = m
pf = []
i = 2
while i * i <= temp:
    if temp % i == 0:
        pf.append(i)
        while temp % i == 0:
            temp = temp // i
    i += 1
if temp > 1:
    pf.append(temp)

ans = 0
for x in range(1, m):
    for y in range(1, m):
        cursed = True
        for p in pf:
            if x % p != 0 and y % p != 0:
                cursed = False
                break
        if cursed:
            ans += 1

print(ans)
