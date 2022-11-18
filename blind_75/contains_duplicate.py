class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        return len(set(nums)) != len(nums)
    
        map = {}
        
        for i in range(len(nums)):
            map[nums[i]] = 1 + map.get(nums[i],0)
        
        for el in map:
            if map[el] > 1:
                return True
        return False
        