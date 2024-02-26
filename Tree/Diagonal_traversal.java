//User function Template for Java

/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
// time complexity is O(N)
// do level order traversal
// for each level poll the element and traverse right till you find null
// and while traversing right add root and all the nodes to the answer array
// also check if left node exist or not if exist add it to queue
// and move to right node
class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
          ArrayList<Integer> ans=new ArrayList<>();
          Queue<Node> q=new LinkedList<>();
          q.add(root);
          while(q.size()>0){// level order traversal
              int tempSize=q.size();
              while(tempSize-->0){
                  Node n=q.poll();// poll element of each level i.e actually left node not right node
                  while(n!=null){// traverse all right node
                      ans.add(n.data);// add right node to answer
                      if(n.left!=null) q.add(n.left);// if left node exist for polled node add it to queue
                      n=n.right;// move current node to right node
                  }
                  
              }
          }
          return ans;
           //add your code here.
      }
}
