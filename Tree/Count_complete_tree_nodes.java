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
 // Time complexity is O(logn2)
 // complete tree is a type of tree where each node is filled with two children node
 // except leaf node that too left side should be filled first then right one
 /// if n is height of then total number of node will be 2^n-1 when left and right height is same
 // else will post order recursively return the count till leftHeight!=rightHeight
 class Solution {
    public int countNodes_(TreeNode root){
        if(root==null) return 0;// when root==0
        int leftHeight=findLeftHeight(root);// finding left height
        int rightHeight=findRightHeight(root);// finding right height
        if(leftHeight==rightHeight){// when leftHeight == right height
            return (int)Math.pow(2,leftHeight)-1;// formula for nodes
        }
        int left=countNodes_(root.left); // left recursive call
        int right=countNodes_(root.right);// right recursive call
        return left+right+1;// eacha node accounts 1

    }
    public int findLeftHeight(TreeNode root){ // finding left height
        int count=0;
        while(root!=null){
            count++;
            root=root.left;


        }
        return count;
    }
    public int findRightHeight(TreeNode root){// finding right height
        int count=0;
        while(root!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int countNodes(TreeNode root) {
        int ans=countNodes_(root);
        return ans;
        
    }
}