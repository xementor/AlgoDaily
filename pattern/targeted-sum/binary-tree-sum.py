
from typing import List, Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
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

        print(result)


root = TreeNode(5)
root.left = TreeNode(4, left=TreeNode(11,left=TreeNode(7), right=TreeNode(2)))
root.right = TreeNode(8,left=TreeNode(13), right=TreeNode(4, left=TreeNode(5), right=TreeNode(1)))
Solution().pathSum(root, 22)
            