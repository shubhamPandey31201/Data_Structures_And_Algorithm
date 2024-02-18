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
 //time complexity is O(n).
 // we use queue for bfs
 // first we add root to the queue
 // then we run loop until queue is not empty 
 // we find current size of queue (in every iteration current size of loop contain no of level elements)
 // we make list to add current level elements
 // again we run inner loop till size of queue is not exhausted
 // then for every peek element we find left and right node if it exists and add it to queue
 // after adding we pop the peek element and add it to the list
 // and level list is added to answer list and returned 
 class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        while(q.size()>0){
            int qsize=q.size();
            List<Integer> levelOrder=new ArrayList<>();
            for(int i=0;i<qsize;i++){
                if(q.peek().left!=null ) q.add(q.peek().left);//adding left node
                if(q.peek().right!=null) q.add(q.peek().right);// adding right node
                levelOrder.add(q.poll().val);// adding front to list
            }
            ans.add(levelOrder);// adding level list to ans list

        }
        return ans;
        
    }
}