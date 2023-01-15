package pattern.subsets.balanced_parenthesis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ParenthesesString {
  String str;
  int openCounot;
  int closeCount;

  public ParenthesesString(
    String s, int openCounot, int closeCount
  ) {
    str = s;
    this.openCounot = openCounot;
    this.closeCount = closeCount;
  }
}

public class Solution {
  public static List<String> generateValidParenthessis(int num){
    List<String> result = new ArrayList<>();
    Queue<ParenthesesString> queue = new LinkedList<>();
    queue.add(new ParenthesesString("", 0, 0));

    while(!queue.isEmpty()) {
      var ps = queue.poll();
      if (ps.openCounot == num && ps.closeCount == num)
        result.add(ps.str);
      else {
        if (ps.openCounot < num)
          queue.add(new ParenthesesString(ps.str + "(", ps.openCounot+1, ps.closeCount));
        if (ps.openCounot > ps.closeCount)
          queue.add(new ParenthesesString(ps.str + ")", ps.closeCount, ps.closeCount+1));
      }
    }

    return result;
  }
  
}
