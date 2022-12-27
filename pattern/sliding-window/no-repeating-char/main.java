import java.util.HashMap;
import java.util.Map;

class NoRepeatSubstring {
    public static int findLength(String str){
        int maxLength = 0;
        int winStart = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int winEnd = 0; winEnd < str.length(); winEnd++) {
            char rightChar = str.charAt(winEnd);
            if (charIndexMap.containsKey(rightChar)) {
                // windows should start from index of previous charecter
                // but we have to see our current windows is already ahead of the occurance
                winStart = Math.max(winStart, charIndexMap.get(rightChar));
            }
            charIndexMap.put(rightChar, winEnd);
            maxLength = Math.max(maxLength, (winEnd - winStart + 1));
        }
        return maxLength;
    }

    public static void main(String[] args) {
        NoRepeatSubstring.findLength("I love you");
    }
}