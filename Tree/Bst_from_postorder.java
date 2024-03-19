
//User function Template for Java
/*class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

// Function should return the root of the bst formed using postorder traversal.
// Time complexity is O(N)
//The intuition is last element in postorder is root element 
// we pass left contraint value and right contraint value in the recusive call funtion
// initially left contraint will be -inifity and right contraint will be +infinity (integer value)
// in case of postorder we first make right recursive call then left recusive call
// for right recursive call the value should be in between root.val to right contraint
// for left recursive call the value should be in between left constraint to root.val
// return root
class GFG
{
    static int idx=0;
    public static Node constructBst(int []post,int leftMin,int rightMax){
        if(idx<0 || post[idx]<leftMin || post[idx]>rightMax){ // in this case return null 
        // here there is either no node or no node to add in left branch or no node to add in right node
            return null;
        }
        Node root=new Node(post[idx--]); // root element
        root.right=constructBst(post,root.data,rightMax);// right recursive call
        root.left=constructBst(post,leftMin,root.data);// left recursive call 
        return root; 
        
        
    }
    public static Node constructTree(int post[],int n)
    {
        int leftMin=Integer.MIN_VALUE; // -infinity
        int rightMax=Integer.MAX_VALUE;// +infinity
        idx=n-1;
        // the first root will always lie in between -infinity and +infinity and later in recursive call contraint will be updated 
        Node root=constructBst(post,leftMin,rightMax);
        return root;
        //Add your code here.
    }
}