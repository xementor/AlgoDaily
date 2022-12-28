import java.util.HashMap;
import java.util.Map;

class StringPermutation {
    public static int findPermutation(String str, String patter) {
        int winStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : patter.toCharArray()) {
            charFrequencyMap.put(
                ch, charFrequencyMap.getOrDefault(ch, 0) + 1
            );
        }

        for (int winEnd = 0; winEnd < str.length(); winEnd ++){
            char rightChar = str.charAt(winEnd);
            if (charFrequencyMap.containsKey(rightChar)) {
            }
        }
        return -1;
    }
}