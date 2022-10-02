# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        out = []
        q = []
        
        if not root:
            return out
        
        q.append(root)
        
        while(len(q) >0):
            levelLength = len(q)
            curL = []
            for _ in range(levelLength):
                curN = q.pop(0)
                curL.append(curN.val)
                if curN.left:
                    q.append(curN.left)
                if curN.right:
                    q.append(curN.right)
            out.append(curL)
        return out
                
                
        
        