x = int(input())

for i in range(x):
    numbers = input().split()
    num1 = numbers[0]
    num2 = numbers[1]

    try:
        num1 = int(num1)
        num2 = int(num2)
        res = num1/ num2
        print(res)
    except ValueError as e :
        print('Error code:', e)
    except ZeroDivisionError:
        print('Error Code: interger division or module by zero')