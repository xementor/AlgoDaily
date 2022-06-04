package Data_Structure.Binary_Search_Tree;

public class BST{
    static class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val = val;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            return new Node(val);
        }
        if(root.val > val){
            insert(root.left, val);
        }

        else if(root.val < val){
            insert(root.left, val);
        }
        return root;
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if (root.val == key){
            return true;
        }
        if (root.val > key){
            return search(root.left, key);
        } else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int key){
        if(root == null){
            return null;
        }
        if (root.val > key){
            root.left = delete(root.left, key);
        } else if (root.val < key){
            root.right = delete(root.right, key);
        } else {
            // case 1
            if(root.left == null && root.right == null){
                return root;
            }

            // Case 2. as only o ne side tree is existed . so if 
            // -- left is null then return root.right
            if (root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;

            }
            Node IS = findInorderSuccesor(root.right);
            root.val = IS.val;
            root.right = delete(root.right, IS.val);
        }
        return root;
    }
    static Node findInorderSuccesor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void inorder(Node root){
        if ( root == null ){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
        System.out.print(root.val+" ");

    }

    public static void main(String args[]){
        int[] values = {12, 34, 1,3,4,5,6};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inorder(root);
        search(root, 4);

    }
}

