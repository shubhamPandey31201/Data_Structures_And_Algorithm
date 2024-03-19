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
 // the intuition is first element in preorder is root element
 // then we find the idx of root element in inorder array
 // the left side of root element in inorder is left subtree node and right side of root element is right subtree node
 // we can find the count of left sub tree nodes as index-start
 // now for recursive call we divide the inorder and preorder and left subtree half and right subtree half
 //for left recursive call preorder start index will be preStart+1(since first element is root) and end index will be start+leftNodesCount
 // and for inorder start will be start and end will be idx-1
 // for right recursive call preorder start will be start+leftnodesCount+1 and end will be preEndIdx
 // and inorder will be idx+1(not idx because idx will be root) and end will be inEndIdx
 // then return root
 class Solution {
    public TreeNode constructTree(int[] preorder,int preStartIdx,int preEndIdx,int[] inorder,int inStartIdx,int inEndIdx){
        if(inStartIdx>inEndIdx) return null; // base condition 
        int idx=inStartIdx;// for finding root in inorder
        while(inorder[idx]!=preorder[preStartIdx]) idx++;// finding root index in inorder
        TreeNode root=new TreeNode(preorder[preStartIdx]);// creating root 
        int totalLeftBranchNodes=idx-inStartIdx;// total left Nodes count
        root.left=constructTree(preorder,preStartIdx+1,preStartIdx+totalLeftBranchNodes,inorder,inStartIdx,idx-1);// left recursive call 
        root.right=constructTree(preorder,preStartIdx+totalLeftBranchNodes+1,preEndIdx,inorder,idx+1,inEndIdx);// right recursive call
        return root;


    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;
        
    }
}