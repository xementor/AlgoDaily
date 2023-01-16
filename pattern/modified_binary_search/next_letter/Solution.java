package pattern.modified_binary_search.next_letter;

public class Solution {
  public static char searchNextLetter(char[] letters, char key) {
    int n = letters.length;
    if (key < letters[0] && key > letters[n-1]) return letters[0]; // here or 

    int start = 0, end = n - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (key < letters[mid]) end = mid - 1;
      else start = mid + 1;
    }
    return letters[start % n];
  }
  
}
