
//User function Template for Java

/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
// Time complexity is O(n)
// do level wise traversal 
// every first element of each level should be added to answer array.

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        Queue<Node> q=new LinkedList<>();
        
        q.add(root);
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        while(q.size()>0){// level wise traversal
            int tempSize=q.size();
            
            ans.add(q.peek().data); // adding first element of each level
            while(tempSize-->0){
                Node n=q.poll();
                if(n.left!=null) q.add(n.left);// adding left node
                if(n.right!=null) q.add(n.right);// adding right node
                
            }
            
        }
        return ans;
      // Your code here
    }
}