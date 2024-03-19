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
 // here the intuition is last element of postorder array will be root element 
 // after making root node 
 // we finding the index of root element in inorder 
 // after finding the index of root element in inorder
 // we can calculate the number of element in left inorder and right order
 // count of left inorder element = idx-inStartIdx
 // the left postorder element will be from postStartIdx to postStartIdx+totalElement-1
 // now for left recursive call 
 // inorder array will be from start to idx-1 
 // postorder array will be from start to postStartIdx+totalElement-1
 // for right recursive call
 // inorder array will be from idx+1 to end
 // postorder array will be from postStartIdx+totalElement to end-1 since end is root element
 class Solution {
    public TreeNode constructTree(int[] inorder,int inStartIdx,int inEndIdx,int[] postorder,int postStartIdx,int postEndIdx){
        if(inStartIdx>inEndIdx) return null; // when there is no element
        TreeNode root= new TreeNode(postorder[postEndIdx]);// last element of postorder is root
        int idx=inStartIdx;
        while(inorder[idx]!=postorder[postEndIdx]) idx++;// finding root element in inorder
        int totalLeftBranchNodes=idx-inStartIdx;// left sub tree nodes count

        root.left=constructTree(inorder,inStartIdx,idx-1,postorder,postStartIdx,postStartIdx+totalLeftBranchNodes-1);// left recursive call
        root.right=constructTree(inorder,idx+1,inEndIdx,postorder,postStartIdx+totalLeftBranchNodes,postEndIdx-1);// right recursive call
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root=constructTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return root;
        
    }
}