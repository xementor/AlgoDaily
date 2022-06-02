import java.util.*;
class Solution
{   
    //Function to return a list of BST elements in a given range.
	public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        // code here.
        result = new ArrayList<Integer>();
        printInRange(root,low,high);
        return result;
       
    }
    static ArrayList<Integer> result = null;
    
    static void  printInRange(Node root, int low, int high){
        if ( root == null ){
            return;
        }
        if( root.data < low){
            printInRange(root.right, low, high);
        } else if ( root.data > high){
            printInRange(root.left, low, high);
        }
        else if ( root.data >= low && root.data <= high ){
            printInRange(root.left,low,high);
            result.add(root.data);
            printInRange(root.right, low, high);
            
        }
    }
    
}
