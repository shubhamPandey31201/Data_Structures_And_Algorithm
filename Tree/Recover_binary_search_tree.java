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
 // we use inorder morris traversal to solve this problem
 // we maintain four variable that is curr,prev ,a and b
 // curr,prev is used to track nodes 
 // while a and b will point the erroneus nodes in the tree 
 // when ever in inorder traversal we are supposed to added the answer to array that time only we check if prevNode > currNode
 // if it is that means prev Node is in wrong place 
 // so a will be prev node
 // and b will be curr node
 // then we move prev node to currNode
 // and currNode to curr right
 // rest everything follow inorder morris traversal





 class Solution {
    public TreeNode findRightMostNode(TreeNode leftNode,TreeNode curr){
        while(leftNode.right!=null && leftNode.right!=curr){// finding rightMost node
            leftNode=leftNode.right;
        }
        return leftNode;
    }
    public void recoverTree(TreeNode root) {
        TreeNode curr=root,a=null,b=null,prev=null;
        while(curr!=null){
            TreeNode leftNode=curr.left;
            if(leftNode==null ){
                if(prev!=null && prev.val>curr.val){ // finding errorneous node

                    if(a==null){
                        a=prev; // first swapping node
                    }
                    b=curr;// second swapping  node
                    
                }
                prev=curr;
                curr=curr.right;

            }
            else{
                // finding rightmost node
                TreeNode rightMostNode=findRightMostNode(leftNode,curr);
                if(rightMostNode.right==null){// forming connection
                    rightMostNode.right=curr;
                    curr=curr.left;
                }
                else{
                    // detaching connection and finding erroneaus nodes
                    rightMostNode.right=null;
                    if(prev.val>curr.val){
                        if(a==null){
                            a=prev;
                        }
                        b=curr;
                        
                        
                    }
                    prev=curr;
                    curr=curr.right;


                }
            }


        }
        // swaping erroneus node
        int temp=a.val;
        a.val = b.val;
        b.val=temp;
        
    }
}