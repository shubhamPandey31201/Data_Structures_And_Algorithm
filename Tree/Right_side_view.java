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
 // Time complexity O(n)
 // simiar to left view 
 // we do level order traversal but first we traverse right node then we traverse left node 
 // recursively 
 // then first element should be added to the answer array

 class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()>0){// lever order traversal
            int tempSize=q.size();
            ans.add(q.peek().val);
            while(tempSize-->0){
                TreeNode n=q.poll();
                if(n.right!=null) q.add(n.right);// adding right node first
                if(n.left!=null) q.add(n.left);// adding left node later
            }

        }
        return ans;
        
        
    }
}