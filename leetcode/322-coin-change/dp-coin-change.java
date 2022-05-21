/**
    DP coin change
    - which amount have to be changed, this size array will be created
    - for every coin, we will store the best solution
    - every time coint will be added and will consider this as well to produce optimal solution
    Recurrage relation
        if i >= coin[j]
            T[i] = min(T[i], 1+T[i-coin[j]])
 */


 class Solution{
     public int coinChange(int[] coins, int amount){
         var table = new int[amount+1];
         var idxTable = new int[amount+1];
         
         // First element 0 and other set to infinity
         table[0] = 0;
         for(int i=1; i<=amount; i++){
             table[i] = 999;
         }

         for(int j=0; j<coins.length; j++){
            for(int i=1; i<=amount; i++){
                if (i >= coins[j]){
                    int temp = table[i];
                    table[i] = Math.min(table[i], 1+table[i-coins[j]]);

                    // when value change in table , update idxTable with this indx
                    if(temp != table[i]){
                        idxTable[i] = j;
                    }
                }
                 
            }
        }


         return table[amount] == 999 ? -1 : table[amount];
     }
 }