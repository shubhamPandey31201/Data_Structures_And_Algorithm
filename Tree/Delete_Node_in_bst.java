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
 // Time complexity will be O(N)
 // there will be four cases to delete a node in bst
 // first when the target node has no children then simply return null
 // second when target has right node but not left node then simply return node.right node
 // third when targe has left node but not right node then simply return node.left node
 // fourth when the node has both left and right node then find the largest node in left branch and change change that value to current node and remove the actual occurence of that node


 class Solution {
    public int max(TreeNode root){
        if(root.right!=null){// since it is bst max node will be in its right side only
            return max(root.right);

        }
        return root.val;
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(key>root.val){ // searching key node where key is greater than current node
            root.right=deleteNode(root.right,key);
        }
        else if(key<root.val){// when key is smaller than current node
            root.left=deleteNode(root.left,key);
        }
        else{ // key==root.val 
            if(root.left!=null && root.right!=null){// when there exist both right and left onde
                int leftMax=max(root.left);// finding left subtree max node
                root.val=leftMax;// changing root val with leftmax
                root.left=deleteNode(root.left,leftMax);// deleting actual leftmax node
                return root;

            }
            if(root.left!=null){// when there exist only left node
                return root.left;
            }
            if(root.right!=null){// when there exist only right node
                return root.right;
            }
            else{ // when there exist no node
                return null;
            }
        }
        return root;
        
    }
}