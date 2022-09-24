class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def getPreIndex():
    return constructTreeUtil.preIndex
 
# Function to increment the value of static variable
# constructTreeUtil.preIndex
 
 
def incrementPreIndex():
    constructTreeUtil.preIndex += 1
 
# A recurseive function to construct Full from pre[].
# preIndex is used to keep track of index in pre[[].
 
 
def constructTreeUtil(pre, low, high):
 
        # Base Case
    if(low > high):
        return None
 
    # The first node in preorder traversal is root. So take
    # the node at preIndex from pre[] and make it root,
    # and increment preIndex
    root = TreeNode(pre[getPreIndex()])
    incrementPreIndex()
 
    # If the current subarray has onlye one element,
    # no need to recur
    if low == high:
        return root
 
    r_root = -1
 
    # Search for the first element greater than root
    for i in range(low, high+1):
        if (pre[i] > root.val):
            r_root = i
            break
 
    # If no elements are greater than the current root,
    # all elements are left children
    # so assign root appropriately
    if r_root == -1:
        r_root = getPreIndex() + (high - low)
 
    # Use the index of element found in preorder to divide
    # preorder array in two parts. Left subtree and right
    # subtree
    root.left = constructTreeUtil(pre, getPreIndex(), r_root-1)
 
    root.right = constructTreeUtil(pre, r_root, high)
 
    return root
 
# The main function to construct BST from given preorder
# traversal. This function mailny uses constructTreeUtil()
 
 
def constructTree(pre):
    size = len(pre)
    constructTreeUtil.preIndex = 0
    return constructTreeUtil(pre, 0, size-1)
 
 
def printInorder(root):
    if root is None:
        return
    printInorder(root.left)
    print (root.val,end=' ')
    printInorder(root.right)


root = [5,4,8,11,None,13,4,7,2,None,None,5,1]
 
root = constructTree(root)
print ("Inorder traversal of the constructed tree:")
printInorder(root)