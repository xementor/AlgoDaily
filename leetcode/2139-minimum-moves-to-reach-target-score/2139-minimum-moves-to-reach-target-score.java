class Solution {
    public int minMoves(int target, int maxDoubles) {
        int move = 0;
        while (target > 1){
            if(maxDoubles < 1){
                return target + move -1;
            }
            if(target % 2 == 0){
                target = target / 2;
                maxDoubles --;
                move ++;
            } else {
                target --;
                move ++;
            }
        }
        return move;
        
    }
}