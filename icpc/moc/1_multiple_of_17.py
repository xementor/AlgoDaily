
for x in range(0,10):
    x = input()

    if int(x) == 0:
        break

    if (int(x) // 10) < 1:
        print('0')
        continue
  
    last_digit = int(x[-1])
    remaining = int(x[:-1])

    res = remaining - (5 * last_digit)
    if res % 17 == 0:
        print('1')
    else:
        print('0')
