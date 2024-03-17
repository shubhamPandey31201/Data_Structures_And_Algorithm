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
 // time complexity is O(n)
 // here we need to to calculate the number of steps required to distribute one coin to each node
 // for that we recursively find extra or defficient for left and right child
 // return value will be l+r+root.val-1 // -1 because 1 will be taken by the node it self
 // and at each recursion stage steps will be added to absolute value of l+r



 class Solution {
    int steps=0;
    public int distributeCoins_(TreeNode root){
        if(root==null) return 0;
        int l=distributeCoins_(root.left); // left recursive call
        int r=distributeCoins_(root.right);// right recursive call
        steps+=Math.abs(l)+Math.abs(r); // calculating steps
        return l+r+root.val-1; // recursion return 
    }
    public int distributeCoins(TreeNode root) {
        distributeCoins_(root);
        return steps; // return steps as final answer
        
    }
}