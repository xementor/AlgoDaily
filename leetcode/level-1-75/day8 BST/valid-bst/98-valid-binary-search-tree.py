from typing import Optional
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def bfs(self, root,flag):
            flag = False
            if not root.left or not root.right:
                return
            
            if (root.left.val < root.val):
                self.bfs(self, root.left,flag)
            else:
                # return False
                flag = False
            if (self, root.right.val > root.val):
                self.bfs(root.right,flag)
            else:
                # return False
                flag = False
    def isValidBST(self, roott: Optional[TreeNode]) -> bool:
        flag = True
        
        self.bfs(roott,flag)
        
        return flag
    
    
        