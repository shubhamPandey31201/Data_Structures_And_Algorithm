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
 // we maintain the previous node that points to previous node in inorder traversal
 // and the intuition is whenever previous node is greater than curr node val that means its not valid binary search tree
 // during inorder operation we check if prev val >= root.val or not if yes then return false
// there can be another method also to store nodes in array during inorder traversal and find if previous index value is greater than current index value but this will have more space complexity

class Solution {
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true; // base case

        if(isValidBST(root.left)==false) return false; // left recursive call

        if(prev!=null && prev.val>=root.val) return false;// inorder operation
        prev=root;// updating prev with current node for comparasion in next recursive call


        if(isValidBST(root.right)==false)return false;// right recursive call
        return true;
        
    }
}