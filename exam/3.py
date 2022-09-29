num = input()
vow = 'AEIOU'
Rahim = 0
Karim = 0
for n in range(len(num)):
    if num[n] in vow:
        Karim += (len(num)-n)
    else:
        Rahim += (len(num)-n)
if Karim > Rahim:
    print ("Karim", Karim)
elif Karim < Rahim:
    print ("Rahim", Rahim)
else:
    print ("Draw")