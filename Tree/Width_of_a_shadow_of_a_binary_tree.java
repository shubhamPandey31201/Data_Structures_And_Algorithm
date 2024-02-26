//User function Template for Java

/*Structure of node of binary tree is as follows
class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
} */
// Time complexity is O(n).
// to visually find the vertical width draw vertical lines as shown in fig and count that
// to calculate width algorithmically 
// we keep index of root node as 0
// and whenever we go to left to root we do -1
// and whenever we go right we do +1
// and calculate the min index to left size
// and maximum index to right size
// maxIdx-minIdx+1 will be the vertical index 
// we traverse left and right to node recursively and store minIdx and maxIdx to the array
class Tree
{
    public static void verticalWidth(Node root,int w,int[] res){
        if(root ==null) return;
        res[0]=Math.min(res[0],w);// to store min index
        res[1]=Math.max(res[1],w);// to store  max index

        verticalWidth(root.left,w-1,res);// recursive call when we go left there is -1 to the index
        verticalWidth(root.right,w+1,res);// recursive call when we go right there is +1 t the index
    }
    //Function to find the vertical width of a Binary Tree.
    public static int verticalWidth(Node root)
	{
	    if(root==null) return 0;
	    int [] res=new int[2];// to store minIdx and maxIdx
        verticalWidth(root,0,res);// methode overloading is there 
        return res[1]-res[0]+1;// maxIdx-minIdx+1 is the vertical Width
	    // code here.
	}
}