
/*Complete the function below*/
// Time complexity is O(N)
// here the intuition is first element of level order traversal is root element always
// so we need to find the index of root element in inorder array 
// after finding root element in inorder array we know from start to idx-1 will be left nodes
// so we added leftnodes in hashset
// now we traverse to levelorder array and check if element is there in hashset or not
// if it's there we add that element into left levelorder array and delete the element in the hashset to optimise searching
// if it's does not exist in hashset that means it is right node value
// after calculating leftlevel order and right level order
// there will be recursive call for root.left and root.right respectively
// and we return root;
class GfG
{
    Node constructTree(int[] inorder,int inStartIdx,int inEndIdx,int[] level){
        if(inStartIdx>inEndIdx) return null; // when there is no element to attach
        
        Node root=new Node(level[0]); // level order first element is root always
        if(level.length==1) return root; // when there is only one element
        int idx=inStartIdx;// to find root element in inorder
        while(inorder[idx]!=level[0]) idx++; // finding root element in inorder arary
        HashSet<Integer> leftNodes=new HashSet<>();// creating hashset that stores left node values
        for(int i=inStartIdx;i<idx;i++){// adding leftnodes values to hashset except root node which is at idx
            leftNodes.add(inorder[i]);
        }
        int totalLeftNodes=idx-inStartIdx;// calculating total number of left nodes
        int[] leftLevelNodes=new int[totalLeftNodes];// left level order stores left nodes values
        int[] rightLevelNodes= new int[inEndIdx-idx];// right level order stores right nodes value
        int l=0;// index for storing left node value in left level order
        int r=0;// index for storing right node value in right level order
        for(int i=1;i<level.length;i++){
            if(leftNodes.size()>0 && leftNodes.contains(level[i])){ // if level order val is in hashset that means it is left level order value
                leftLevelNodes[l]=level[i];// adding to left level order array
                leftNodes.remove(level[i]);// deleting element for hashset to optimise search
                l++;// incrementinng leftLevelNode index
            }
            else{
                rightLevelNodes[r]=level[i];// adding to right level order array
                r++;// incrementing right level Node index
            }
        }
        root.left=constructTree(inorder,inStartIdx,idx-1,leftLevelNodes);// left recursive call
        root.right=constructTree(inorder,idx+1,inEndIdx,rightLevelNodes);// right recursive call
        return root;
    }
    Node buildTree(int inord[], int level[])
    {
        Node root=constructTree(inord,0,inord.length-1,level);
        return root;
        //your code here
    }
    
   
}
