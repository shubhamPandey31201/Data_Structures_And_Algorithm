//User function Template for Java
// Time complexity is O(n).

class Solution
{
    static class valToIndex{ // making data structures that stores values and index to which that value has to be stored
        Node node=null;
        int index=0;
        valToIndex(Node node, int index){
            this.node=node;
            this.index=index;

        }

    }
    public static void verticalWidth(Node root,int i,int []ans){// finding vertical width
    // to understand the prcess loook for solution of vertical width question
        if(root==null) return;
        ans[0]=Math.min(ans[0],i);
        ans[1]=Math.max(ans[1],i);
        verticalWidth(root.left,i-1,ans);
        verticalWidth(root.right,i+1,ans);
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        
        int[] minMax=new int[2];// finding min and max index
        verticalWidth(root,0,minMax);
        int len=minMax[1]-minMax[0]+1;// finding the vertical width of the tree
        for(int i=0;i<len;i++){// assigning new arrayList to all the indexes
        // here to 0th index all the element that lies to the 0th vertical index will be added 
        // The min Index will be converted to 0 and root index will be the Math.abs(minMax[0])
            result.add(new ArrayList<Integer>());
        }
        Queue<valToIndex> q=new LinkedList<>();
        q.add(new valToIndex(root , Math.abs(minMax[0]))); // root's index will be Math.abs(minMax[0] just to avoid negative indexing)
        while(q.size()>0){// level order traversal
            int tempSize=q.size();
            
            while(tempSize-->0){
                valToIndex popped=q.poll(); // pop the element from the queue 
                int poppedIdx=popped.index;// finding the index of the popped element
                int val=popped.node.data;// finding the value of the popped element
                result.get(poppedIdx).add(val);// adding the value to the respective index to the answer array
                if(popped.node.left!=null) q.add(new valToIndex(popped.node.left,poppedIdx-1));// traversing left of the node also subracting -1
                if(popped.node.right!=null) q.add(new valToIndex(popped.node.right,poppedIdx+1));// traversing right by adding +1
                
            }
        }
        
        
        for(int i=0;i<len;i++){// adding the all the element of subarray to a single array
            List<Integer> arr=result.get(i);
            for(int e:arr){
                ans.add(e);
                
                
            }
        }
        return ans;

        // add your code here
    }
}