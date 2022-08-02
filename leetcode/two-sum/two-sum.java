class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++){
            int requiredNum = target - nums[i];
            
            if (map.containsKey(requiredNum)){
                int[] res = { map.get(requiredNum), i};
                return res;
            }
            map.put(nums[i], i);
        }
        return null;
        
        
    }
}