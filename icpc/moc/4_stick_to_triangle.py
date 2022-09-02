

t = int(input())

for i in range(t):
    c = int(input())
    res = []
    half = c//2
    count = 0
    for x in range(1,half):
        second = half - x
        for y in range(second,half):
            z = c - (x + y)
            data = [x,y,z]
            data.sort()
            if data not in res:
                res.append(data)
                count += 1
                # print(data)


    print(count)