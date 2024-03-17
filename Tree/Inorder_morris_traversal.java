/* A Binary Tree node 

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
// Time complexity is O(N)
// Using morris traversal
// Morris traversal helps to traverse tree in constant space 
// what we do is we attach right pointer of calculated leaf node to respective predecessor node
// for inorder traversal using morris traversal 
// take currNode as root
// then run loop until curr!=null 
// then find leftNode for currNode
// then check if LeftNode is null or not
// if leftNode is null that means it is the inorder node to be added and in the answer array
// if not then we calculate the rightMost node to the leftNode
// there can be two types of right most node 
// 1st type is either the rightmost right will be null else rightmost right will be currNode itself
// so when rightmost right is null we attatch the rightmost right to the current node and move current node to its left
// while if rightmost right is currNode that means currNode should now be added to answer since it is now inorder node 
// before adding node to answer break the pointer
// and then move current node to its right
class Solution
{
    Node findRightMostNode(Node leftNode,Node curr){ // function to find the rightmost node
        while(leftNode.right!=null && leftNode.right!=curr){
            leftNode=leftNode.right;
        }
        return leftNode;
    }
    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root)
    {
        ArrayList<Integer> ans=new ArrayList<>(); // stores answer data
        Node curr=root;
        while(curr!=null){ 
            Node leftNode=curr.left;
            if(leftNode==null){// curr data should be added and curr should be move to right
                ans.add(curr.data);
                curr=curr.right;
                
            }
            else{
                Node rightMostNode=findRightMostNode(leftNode,curr);
                if(rightMostNode.right==null){ // form a connection (morris connection)
                    rightMostNode.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMostNode.right=null;// break the connection
                    ans.add(curr.data);// and add the currNode data to the answer 
                    curr=curr.right;// move to right of curr node
                    
                }
            }
        }
        return ans;
        // Code
    }
    
    
}