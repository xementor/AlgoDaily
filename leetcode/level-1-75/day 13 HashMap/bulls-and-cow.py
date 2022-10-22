class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        char_s = set(secret)
        
        cow = 0
        bull = 0
        
        for ch in char_s:
            in_secret = secret.count(ch)
            in_guess = guess.count(ch)
            
            cow += in_secret if in_secret <= in_guess else in_guess
        
        print(cow)
        
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                cow -= 1
                bull += 1
                
        return f"{bull}A{cow}B"
        
        