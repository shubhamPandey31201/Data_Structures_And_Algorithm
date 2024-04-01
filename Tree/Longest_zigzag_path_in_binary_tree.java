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
 // for a root we check which one left node or right node is giving longest zigzag path
 class Solution {
    class Pair{ // for each node it will have length with forward slash and length with backwardslash 
    // and maxLen till now
        int forwardSlash=-1;
        int backwardSlash=-1;
        int maxLen=0;
    }
    public Pair longestZigZag_(TreeNode root){
        if(root==null) return new Pair(); // whenever root is null return new pair
        // where forwardSlash will be -1
        // backwardSlash will also be -1
        // and maxLen will be 0
        Pair left=longestZigZag_(root.left); // will return values for left subtree
        Pair right=longestZigZag_(root.right);// will return value for right subtree
        Pair newPair=new Pair(); // pair for each node
        newPair.maxLen=Math.max(Math.max(left.maxLen,right.maxLen),Math.max(left.backwardSlash+1,right.forwardSlash+1)); // maxlen will be maximum of left.maxLen , right.maxLen, maxof(left.backwardSlash+1,right.forwardSlash+1) 1 is added because it contains root
        newPair.backwardSlash=right.forwardSlash+1; // new pair backwardslash will form longest path with right.forwardslash+1
        newPair.forwardSlash=left.backwardSlash+1;// new pair forwardslash will form longeset path with left.backwardslash+1
        
        return newPair;
    }
    public int longestZigZag(TreeNode root) {
       
        Pair ans=longestZigZag_(root);
        return ans.maxLen;
        
    }
}