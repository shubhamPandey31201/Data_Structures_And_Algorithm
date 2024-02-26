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
 // first calculate number of left node to x and number of right node to x recursively
// then calculate remaining Node that will be equal to n-(lc+rc+1)
// 1 is included because x is there
// then see max of remaining node,leftNode count, rightNode count
// whatever is max is should be greater than n/2
// if yes return true else return false
class Solution {
    int lc=0;
    int rc=0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        
        count_left_and_right_of_x(root,x);// with this call we get lc and rc
        int remainingNodes=n-(lc+rc+1);// remaining nodes except lc and rc and x included
        int max=Math.max(remainingNodes,Math.max(lc,rc));// max of all these 
        if(max>n/2) return true;// max> n/2 then win else loose
        return false;
        
    }
    public int count_left_and_right_of_x(TreeNode root,int x){
        if(root==null){
            return 0;
        }
        int left=count_left_and_right_of_x(root.left,x);// contains left count
        int right=count_left_and_right_of_x(root.right,x);// contains right count
        if(root.val==x){// condition when it actually take leftCount and right count with respect to x node
        // it calculates lc and rc while backtracking
            lc=left;
            rc=right;
        }
        return left+right+1;// +1 because it includes the current node as well

    }
}