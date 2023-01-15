package pattern.subsets.duplicate_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  public static List<List<Integer>> findSubsets(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    int startIdx = 0, endIndex = 0;
    for(int i=0; i < nums.length; i++) {
      startIdx = 0;
      // if current and the previous elements are same, create same
      // subset only creater before this iteration
      if (i > 0 && nums[i] == nums[i-1])
        startIdx = endIndex+1;
      
      endIndex = subsets.size() - 1;

      for (int j=startIdx; j <= endIndex; j++) {
        List<Integer> set = new ArrayList<>(subsets.get(j));
        set.add(nums[i]);
        subsets.add(set);
      }
    }
    return subsets;
  }
  
}
