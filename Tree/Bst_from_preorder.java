/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
// Time complexity is O(N)
//The intuition is first element in preorder is root element 
// we pass left contraint value and right contraint value in the recusive call funtion
// initially left contraint will be -inifity and right contraint will be +infinity (integer value)
// in case of preorder we first make left recursive call then right recusive call
// for left recursive call the value should be in between left contraint to root.val
// for right recursive call the value should be in between  root.val to right contraint
// return root
class Solution {
    int idx=0;
    public TreeNode constructBst(int[] preorder,int leftMin,int rightMax){
        if(idx>=preorder.length || preorder[idx]<leftMin || preorder[idx]>rightMax){ // base case
        // in this case return null 
        // here there is either no node or no node to add in left branch or no node to add in right node
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx++]);// root element 
        root.left=constructBst(preorder,leftMin,root.val);// left recursive call
        root.right=constructBst(preorder,root.val,rightMax);// right recursive call
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int leftMin=Integer.MIN_VALUE; // -infinity
        int rightMax=Integer.MAX_VALUE;// +infinity
        TreeNode root=constructBst(preorder,leftMin,rightMax);
         // the first root will always lie in between -infinity and +infinity and later in recursive call contraint will be updated 
        return root;
        
    }
}