//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
// time complexity O(n)
// do vertical order traversal 
// each first element to the vertical order traversal will be added to answer array 
// and that will be the answer 

class Solution
{
    static class valToIdx{// making data structures that stores values and index to which that value has to be stored
        Node node=null;
        int index=0;
        public valToIdx(Node node,int index){
            this.node=node;
            this.index=index;
        }
    }
    static void verticalWidth(Node root,int i,int[] minMax){// finding vertical width
    // to understand the prcess loook for solution of vertical width question
        if(root == null) return;
        minMax[0]=Math.min(minMax[0],i);
        minMax[1]=Math.max(minMax[1],i);
        verticalWidth(root.left,i-1,minMax);
        verticalWidth(root.right,i+1,minMax);
    }
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    
    {
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        int minMax[]=new int[2];// finding min and max index
        verticalWidth(root,0,minMax);
        int len=minMax[1]-minMax[0]+1;
        for(int i=0;i<len;i++){// assigning new arrayList to all the indexes
        // here to 0th index all the element that lies to the 0th vertical index will be added 
        // The min Index will be converted to 0 and root index will be the Math.abs(minMax[0])
            result.add(new ArrayList<Integer>());
        }
        Queue<valToIdx> q=new LinkedList<>();
        q.add(new valToIdx(root,Math.abs(minMax[0])));// root's index will be Math.abs(minMax[0] just to avoid negative indexing)
        while(q.size()>0){// level order traversal
            int tempSize=q.size();
            while(tempSize-->0){
                valToIdx popped=q.poll();// pop the element from the queue 
                int poppedIdx=popped.index;// finding the index of the popped element
                int val=popped.node.data;// finding the value of the popped element
                result.get(poppedIdx).add(val);// adding the value to the respective index to the answer array
                if(popped.node.left!=null) q.add(new valToIdx(popped.node.left,poppedIdx-1));// traversing left of the node also subracting -1
                if(popped.node.right!=null) q.add(new valToIdx(popped.node.right,poppedIdx+1));// traversing right by adding +1
            }
        }
        
        for(int i=0;i<len;i++){
            ans.add(result.get(i).get(0));// adding first element of subarray into the answer array
        }
        return ans;
        
        
        // add your code
        
    }
}