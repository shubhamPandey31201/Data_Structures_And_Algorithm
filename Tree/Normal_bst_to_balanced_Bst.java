/*class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

// Time complexity is O(N)
// here by doing inorder traversal store nodes in array
// now the intuition is the middle element will be root node for balanced tree 
// now we make middle as root node 
// and from start to mid-1 will be left recursive call
// and from mid+1 to end will be right recursive call

class GfG
{
    ArrayList<Node> arr=new ArrayList<>();
    
    // for storing unbalanced tree nodes in array
    void inorder(Node root) 
    {
        if(root==null) return;
        
        inorder(root.left);
        arr.add(root);
       
        inorder(root.right);
        
        
        //Add your code here.
    }
    /// balancing tree 
    Node solve(int low,int high){
        if(low>high) return null;// base case
        
        int mid=low+(high-low)/2;// mid node is root node
        Node root=arr.get(mid); // root node
        root.left=solve(low,mid-1);// left recursive call
        root.right=solve(mid+1,high);// right recursive call
        return root;
    }
    Node buildBalancedTree(Node root) 
    {
        inorder(root);// storing in array
        
        int low=0;
        int high=arr.size()-1;
        
        Node node=solve(low,high);// balancing tree
        return node;
        //Add your code here.
    }
}

