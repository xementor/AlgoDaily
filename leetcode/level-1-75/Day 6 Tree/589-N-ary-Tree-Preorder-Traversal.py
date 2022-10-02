"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""

"""
stack solution of dfs
"""

class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        out = []
        stack = []
        if not root:
            return out
        stack.append(root)
        
        while(len(stack) > 0):
            node = stack.pop()
            out.append(node.val)
            childrens = node.children
            childrens = reversed(childrens)
          
            for n in childrens:
                stack.append(n)
        return out
        