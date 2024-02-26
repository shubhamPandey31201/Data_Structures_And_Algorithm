/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
// time complexity is O(n)
// first do level order traversal from right to left (right view)
// the reverse the array 
/// reversed array will be the answer
class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
         ArrayList<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(q.size()>0){// level order traversal 
            int tempSize=q.size();
            while(tempSize-->0){
                Node n=q.poll();
                ans.add(n.data);
                if(n.right!=null) q.add(n.right);// traversing right
                if(n.left!=null) q.add(n.left);// traversing left
            }
            
        }
        // reversing the array
        int len=ans.size();
        int i=0;
        int j=len-1;
        while(i<=j){
            int temp=ans.get(i);
            ans.set(i,ans.get(j));
            ans.set(j,temp);
            i++;
            j--;
        }
        return ans;
        // code here
    }
}      