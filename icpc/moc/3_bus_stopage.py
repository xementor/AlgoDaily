t = int(input())

for j in range(t):
    n = int(input())
    stops = []
    for i in range(n-1):
        data = input()
        first, second = data.split()
        stops.append([int(first), int(second)])
    
    maximum = 0
    people = 0
    for stop in stops:
        people += stop[0] - stop[1]
        maximum = max(maximum, people)
    print(f"Case {j+1}:",maximum)


