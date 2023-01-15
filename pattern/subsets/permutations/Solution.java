package pattern.subsets.permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>(); 
    Queue<List<Integer>> permutations = new LinkedList<>();
    permutations.add(new ArrayList<>());
    for (int currNum: nums) {
      // we will take all existing permuations and add the current num
      int n = permutations.size();
      for(int i=0; i<n; i++){
        List<Integer> oldPermutation = permutations.poll();
        for (int j=0; j < n; j++) {
          // create a new permutation
          List<Integer> newPermutation = new ArrayList<>(oldPermutation);
          newPermutation.add(j, currNum);
          if (newPermutation.size() == nums.length) result.add(newPermutation);
          else permutations.add(newPermutation);
        }
      }
    }
    return result;

  }
  
}
