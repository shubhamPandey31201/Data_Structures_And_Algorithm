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
 //Time complexity is O(n)
 // intuition is inorder traversal gives element in ascending sorted order in case of bst when travelled left root and right
 // and when travelled inorder only but right root and left gives ascending order
 // we maintain a sum variable 
 // traverse inorder (right root left)
 // since we traverse max node first we add val to sum 
 // and add that sum to root.val
 class Solution {
    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root!=null){
            bstToGst(root.right);// inorder right
            
            sum+=root.val;// root operation required in question
            root.val=sum;
            bstToGst(root.left);// inorder left
        }
        return root;
        
    }
}