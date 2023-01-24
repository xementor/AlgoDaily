package leetcode_daily.palindrome_partitioning_131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    dfs(0, result, new ArrayList<String>(), s);
    return result;
  }

  private void dfs(int start, List<List<String>> result, List<String> currenList, String s) {
    if (start >= s.length()) result.add(currenList);
    for (int end = start; end < s.length(); end++) {
      if (isPalindrom(s,start, end)) {
        currenList.add(s.substring(start, end+1));
        dfs(end+1, result, currenList, s);
        currenList.remove(currenList.size()-1);
      }
    }
  }

  private boolean isPalindrom(String s, int start, int end) {
    while (start < end)
      if (s.charAt(start++) != s.charAt(end--)) return false;
    return true;
  }
  
}
