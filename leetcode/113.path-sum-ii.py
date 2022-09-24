#
# @lc app=leetcode id=113 lang=python3
#
# [113] Path Sum II
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        result = []
        li = []
        def dfs(root, Sum):
            if (root == None):
                return
            li.append(root.val)
            if (not root.left and not root.right):
                if (Sum == root.val):
                    result.append(li.copy())
                    li.pop()
                    return
                else:
                    li.pop()
                    return

            dfs(root.left, Sum - root.val)
            dfs(root.right, Sum - root.val)
            li.pop()
            
        dfs(root,targetSum)
        return result
            
        
# @lc code=end

