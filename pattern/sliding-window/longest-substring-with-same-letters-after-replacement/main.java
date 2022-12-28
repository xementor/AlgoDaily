import java.util.HashMap;
import java.util.Map;

class CharacterReplacement {
    public static int findLength(String str, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int winStart = 0;
        int maxRepeatLetterCount = 0;
        int maxLength = 0;
        for ( int windowEnd = 0; windowEnd < str.length(); windowEnd++ ) {
            Character rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(
                rightChar, 
                charFrequencyMap.getOrDefault(rightChar, 0) + 1
            );
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charFrequencyMap.get(rightChar));

            int winLen = windowEnd - windowEnd + 1;
            if ( winLen - maxRepeatLetterCount  > k ) {
                char leftChar = str.charAt(winStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) -1);
                winStart ++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowEnd + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("amrnamer", 3));
    }
}