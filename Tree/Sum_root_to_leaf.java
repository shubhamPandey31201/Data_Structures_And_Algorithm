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
 // Time complexity is O(n)
 // here we only add when we reach to leaf node 
 // and when root left and root right is null that means it is leaf node 
 // preorderly we add sum and whenever we reach to leaf node we add sum to final answer

 class Solution {
    int ans=0;
    public void sumNumbers_(TreeNode root,int sum){
        if(root==null) return ; // base case
        sum*=10;
        sum+=root.val;// making number
        if(root.left==null && root.right==null){
            ans+=sum;// adding it to answer
            return;
        }
        sumNumbers_(root.left,sum);// left recursive call
        sumNumbers_(root.right,sum);// right recursive call

    }
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sumNumbers_(root,0);
        return ans;
        
    }
}