from typing import List
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:

        # start and end of row and column 
        sr,er = 0, len(matrix) - 1
        sc, ec = 0, len(matrix[0]) - 1
        
        
        res = []

        # direction 1 == right, 2 == down, 3 == left, 4 == up
        dir = 1
        
        while (sr <= er and sc <= ec):
            if dir == 1:
                # as dir 1 so have to go right
                for i in range(sc, ec+1):
                    res.append(matrix[sr][i])
                
                # next make dir 2 to go down
                dir += 1
                # at the same time increment start row as it traversal ended
                sr += 1
            elif dir == 2:
                for i in range(sr, er+1):
                    res.append(matrix[i][ec])
                dir += 1
                ec -= 1
            elif dir == 3:
                for i in range(ec, sc-1, -1):
                    res.append(matrix[er][i])
                dir += 1
                er -= 1
            elif dir == 4:
                print('fuck')
                for i in range(er, sr-1, -1):
                    res.append(matrix[i][sc])
                sc += 1
                dir = 1
                
        
                
                
        return res   
        