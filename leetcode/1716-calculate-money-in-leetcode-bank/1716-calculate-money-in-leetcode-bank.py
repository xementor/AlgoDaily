
class Solution:
    def totalMoney(self, n: int) -> int:
        
        Sweek = 1;
        start_day = 1
        money = 0
        
            
        while n > 0 :
            start_day = Sweek;
            if  math.floor(n / 7) > 0:
                for i in range(7):
                    money += start_day
                    start_day += 1
                n -= 7
            else:
                for i in range(n):
                    money += start_day
                    start_day += 1
                    n -= 1
            Sweek += 1
            # week -= 1
        return money
            
            
            
        
            
        
        