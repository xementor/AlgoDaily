package pattern.subsets.subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static List<List<Integer>> findSubsets(int[] nums){
    List<List<Integer>> subsets = new ArrayList<>();
    // start by adding the empty subset
    subsets.add(new ArrayList<>());
    for (int currNum: nums) {
      int n = subsets.size();
      for (int i=0; i < n; i++) {
        List<Integer> set = new ArrayList<>(subsets.get(i));
        set.add(currNum);
        subsets.add(set);
      }
    }

    return subsets;
  }
  
}
