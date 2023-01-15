package pattern.subsets.string_permutations_case_changeing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  private static List<List<Character>> string_permutations_case_changeing(String str) {
    List<List<Character>> result = new ArrayList<>();

    if (str == null) return result;

    Queue<List<Character>> permutations = new LinkedList<>();
    permutations.add(new ArrayList<>());


    for (char currentChar : str.toCharArray()){
      int n = permutations.size();
      for (int i=0; i<n; i++) {
        var oldPermutation = permutations.poll();
        for (int j=0; j < n; j++) {
          var newPermutation = new ArrayList<>(oldPermutation);
          newPermutation.add(j,currentChar);

          if (newPermutation.size() == str.length()) result.add(newPermutation);
          else permutations.add(newPermutation);
        }
      }
    }


    return result;
  }

  public static List<String> findLetterCaseStringPermutation(String str){
    List<String> permuatations = new ArrayList<>();
    if (str == null) return permuatations;
    permuatations.add(str);

    for(int i=0; i<str.length(); i++) {
      if (Character.isLetter(str.charAt(i))) {
        int n = permuatations.size();
        for (int j=0; j < n; j++) {
          char[] chs = permuatations.get(j).toCharArray();
          if (Character.isUpperCase(chs[i]))
            chs[i] = Character.toLowerCase(chs[i]);
          else chs[i] = Character.toUpperCase(chs[i]);
          permuatations.add(String.valueOf(chs));
        }
      }
    }
    return permuatations;
  }

  public static void main(String[] args) {
    var result = string_permutations_case_changeing("ami");

    result.stream().forEach(list -> list.forEach(System.out::print));
    System.out.println(result);
  }
  
}
