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
 // here again we use pre-order morris traversal
 // first consider rootNode as currentNode
 // then until currNode is not equal to null 
 // calculate leftnode as curr left
 // now if leftNode!=null find the rightMost node 
 // where rightMost node is when rightmost right is equal to null
 // now attach rightmost node right to curr.right
 // curr.right=curr.left;
 //curr.left=null;

 // now move curr to curr.right
 class Solution {
    TreeNode FindRightMostNode(TreeNode leftNode){
        while(leftNode.right!=null){
            leftNode=leftNode.right;
        }
        return leftNode;
    }
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            TreeNode leftNode=curr.left;
            if(leftNode!=null){
                TreeNode rightMostNode= FindRightMostNode(leftNode);
                rightMostNode.right=curr.right; 
                curr.right=curr.left;
                curr.left=null;// breaking left pointer since right and left now points to same node
                
            }
            curr=curr.right; // dry run and understand
        }
        
    }
}