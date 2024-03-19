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
 // we divide both preorder and postorder array into left and right sub-brach recursive to build the tree
 // to divide array into right and left we need to know the start and end index of both array
 // so the intuition is 
 // first element of the preorder array is root node 
 // then we find number element in the left array by searching next of root in preorder element in the postorder
 // since that element will be the last element of left subarray in postorder
 // after finding count of left branch nodes we can get right brach nodes as well 
 // then we recusively call the construct function for root.left and root.right respectively
 // lastly we return root
 class Solution {
    public TreeNode constructTree(int[] preorder,int preStartIdx,int preEndIdx,int[] postorder,int postStartIdx,int postEndIdx){
        if(preStartIdx>preEndIdx) return null; // when there is no node
        TreeNode root=new TreeNode(preorder[preStartIdx]);
        if(preStartIdx==preEndIdx) return root; // when there is one node
        

        int idx=postStartIdx; // for search root.left node of preorder in postorder 
        // which actually gives count of nodes left sub tree
        while(postorder[idx]!=preorder[preStartIdx+1]) idx++;

        int totalLeftBranchNodes=idx-postStartIdx+1; // count of left subtree nodes

        root.left=constructTree(preorder,preStartIdx+1,preStartIdx+totalLeftBranchNodes,postorder,postStartIdx,idx); // left recursive call
        // preStartIdx+1 because preStartIdx is root 
        // preStartIdx+totalLeftBranchNodes upto this is left branch node for preorder
        // idx is actually count of leftNodes in postorder and is last element in post order array for left sub tree

        
        root.right=constructTree(preorder,preStartIdx+totalLeftBranchNodes+1,preEndIdx,postorder,idx+1,postEndIdx-1);
        // since preStartIdx+totalLeftBranchNodes was last for left sub-tree so preStartIdx+totalLeftBranchNodes+1 will be start for right preorder
        //postEndIdx-1 since postEndIdx is root element
        // idx+1 since idx was last element for left postorder

        return root;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root=constructTree(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
        return root;
        
    }
}