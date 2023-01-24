/*
    1. First Coming in mind, Recursion would be possible | why
        - based on i've found a diceition tree like things in example.
        - depth of triangle is len of triangle.
        - in every depth, pillar would be = number of depth
        - BASE CASE
            - if depth is gretter to len(triangle) then return
            - get confused what to return what not to.
            - in first base case what i should return?
                - 0 can be returned | why?
                - As in later depth we don't need calculation.
            - In recursive function, some value will be added,
            - but which value should be added?
            - it may be my current stack result + upperstack resutl.
            - in current call stack , where value get's stored?
            - but where the calculation part?
            - calculation part is just I'am in which depth and index and this current value with result.
            = I cann't believed that this code word, for Time limite Exceedeed. now i've to work on optimization.
            = There was a drawback to think my recursion after watchinga a solution, it gets' clear
            - base case should be any kind of computition.
    2. Bottom Up Aproach
        - This aproach is new for me, I am preetty much impressed with this aproach
        - it is somethings, going last element to top.
        - checking min of j and j+1.
            

*/

class Solution {
    List<List<Integer>> triangle = null;
    
    // Recursive
    // Tried traingle not to pass every time.
    // hope was it will save time 
    
    public int minimumTotal2(List<List<Integer>> triangle) {
        this.triangle = triangle;
        return sum (0, 0 );
    }
    
    int sum (int depth, int index) {
        
        // Base case
        if ( depth == this.triangle.size()) {
            return 0;
        }
        
        int result =  this.triangle.get(depth).get(index) + Math.min(sum(depth+1, index) , sum(depth+1, index+1));
       
        return result;
        
    }
    
    // Down up dp aproach.
    
  public int minimumTotal(List<List<Integer>> triangle) {
      
    int[] A = new int[triangle.size()+1];
      
    for(int i=triangle.size()-1;i>=0;i--){
        
        for (int j=0; j<triangle.get(i).size(); j++)
        {
            A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
        }
    }
    return A[0];
}
}
