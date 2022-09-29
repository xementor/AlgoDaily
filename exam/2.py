from itertools import permutations
x = input()
x = x.lower()
# x = 'banana'
vowels = [ 'a', 'e', 'i', 'o', 'u']

karim = rahim = 0

for i in range(len(x)):
    if x[i] in vowels:
        karim = i
        break

for i in range(len(x)):
    if x[i] not in vowels:
        rahim = i
        break

karim_s = x[karim:]
rahim_s = x[rahim:]


xxx = []

for i, ch in enumerate(karim_s):
    for k in range(i, len(karim_s)):
        xxx.append(karim_s[i:k+1])
  


karim_count = []
for el in xxx:
    if el[0] in vowels:
        karim_count.append(el)




yyy = []


for i, ch in enumerate(rahim_s):
    for k in range(i, len(rahim_s)):
        yyy.append(rahim_s[i:k+1])
  



rahim_count = []
for el in yyy:
    if el[0] not in vowels:
        rahim_count.append(el)

for i, ch in enumerate(karim_s):
    for k in range(i, len(karim_s)):
        xxx.append(karim_s[i:k+1])


if len(rahim_count) > len(karim_count):
    print("Rahim: " ,len(rahim_count))
elif len(rahim_count) < len(karim_count):
    print("Karim: ",len(karim_count))
else:
    print('draw')




