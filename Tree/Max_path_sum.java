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
 //Time complexity is O(N)
 // here we need to find the maximum path between two node in the bst 
 // maximum path is the sum of value of nodes with connections
 // there may be cases like 
 // from root to left branch is giving maximum path 
 // from root to right branch is giving maximum path 
 // from left to right including root node is giving maximum path 
 // so we recusively calculate the maximum sum till left branch and right branch 
 // we compare all maximum value and update it with rootToNode and nodeToNode and return in pairSum object
 // lastly pairsum.NodeToNode will be the answer to be returned

 
 public class PairSum{
    int nodeToNode=Integer.MIN_VALUE; 
    int rootToNode=0; // to consider root we don't keep negative integer here
}
class Solution {
public int findMax(int... arr){// finds the maximum among all 
// the parameter acts as array 
    int max=arr[0];
    for(int e:arr){
        if(e>max){ // updating max
            max=e;
        }
    }
    return max;
}

public PairSum maxPathSum_(TreeNode root) {
    if(root==null) return new PairSum();

    PairSum leftNode=maxPathSum_(root.left); // returns maxsum till left 
    PairSum rightNode=maxPathSum_(root.right);// returns maxsum till right

    PairSum myAns=new PairSum(); // pairsum has two attributs is root to node max and node to node maximum

    int maxRootToNode=Math.max(leftNode.rootToNode,rightNode.rootToNode)+root.val;// calculating maximum of rootToNode+root.val
    int maxNodeToNode=findMax(maxRootToNode,leftNode.rootToNode+rightNode.rootToNode+root.val,root.val,leftNode.nodeToNode,rightNode.nodeToNode);
    // maxNodeToNode returns the overall max

    maxRootToNode=Math.max(maxRootToNode,root.val);// there may be condition when root.val is maximum among all

    myAns.rootToNode=maxRootToNode;// attach the calculated max value to the ansPair
    myAns.nodeToNode=maxNodeToNode;
    return myAns;


    
}
public int maxPathSum(TreeNode root) {
    if(root==null) return 0;
    return maxPathSum_(root).nodeToNode; // always nodeToNode will contain maximum path
    
}
}