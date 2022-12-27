import java.util.HashMap;
import java.util.Map;

class MaxFruitCountOf2Type {
    public static int findLength(char[] arr){
        /*
         * Only modification is len of our windows should be 2 
         */
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        int windowStart = 0;
        int maxLength = 0;
        for (int windowEnd=0; windowEnd < arr.length; windowEnd++){
            fruitFrequencyMap.put(
                arr[windowEnd],
                fruitFrequencyMap.getOrDefault(arr[windowEnd], 0)
            );
            while (fruitFrequencyMap.size() > 2){
                fruitFrequencyMap.put(
                    arr[windowEnd], 
                    fruitFrequencyMap.get(arr[windowEnd]) -1
                );
                if (fruitFrequencyMap.get(arr[windowEnd]) == 0){
                    fruitFrequencyMap.remove(arr[windowEnd]);
                }
                windowStart ++;
            }
            maxLength = Math.max((windowEnd - windowStart + 1), maxLength);

        }
        return maxLength;
    }

}