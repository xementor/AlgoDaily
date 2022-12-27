import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;

class LongestSubstringKDistinc {
    public static int findLength(String str, int k){
        /*
         * Time complexity: O(N+N)
         */
        int maxLength = 0;
        int winStart = 0;
        // Can we solve this problem only confirming a char avaiable in arr or not.
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0));
            // shrink the window, until we are left with k distinct char
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(winStart);
                charFrequencyMap.put(
                    leftChar, 
                    charFrequencyMap.get(leftChar) -1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                winStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - winStart + 1);
        }
        return maxLength;
    }
}