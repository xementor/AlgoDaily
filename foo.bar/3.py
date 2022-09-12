def solution(x, y):
    
    start = 1
    for i in range(y):
        start += i


    dis = y+1
    for i in range(x-1):
        start += dis+i;

    print(start)

solution(2,3)