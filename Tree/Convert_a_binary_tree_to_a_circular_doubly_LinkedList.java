//User function Template for Java



//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
//Time complexity is O(N)
// we solve this problem using morris traversal

// we first make a dummy node
// also we assign dummy node to previous node at first
// root is assigned to current node
// when ever there is inorder condidtion i.e either leftNode is equal to null o
// or rightmost right is currNode 
// that time first break the connection if there exist (rigmostNode.right=null)
// than attach currnode to previous right and attach previous to curr.left
// and move prev to curr and curr to curr.right
// this process makes doubly linked list
// at last stage dummy next will be head 
// and previous pointer will point to tail node 
// so we attach previous.right to head and head.left will be previous again to make it cll

class Solution
{ 
    Node findRightMostNode(Node leftNode,Node currNode){
        while(leftNode.right!=null && leftNode.right!=currNode){
            leftNode=leftNode.right;
        }
        return leftNode;
    }
    //Function to convert binary tree into circular doubly linked list.
    Node bTreeToClist(Node root)
    {
        Node dummy=new Node(-1);// creating dummy node
        Node prev=dummy,curr=root;
        // morris inorder traversal
        while(curr!=null){
            Node leftNode=curr.left;
            if(leftNode==null){// making doubly connection 
                prev.right=curr;
                curr.left=prev;
                prev=curr;
                
                curr=curr.right;
                
            }
            else{
                Node rightMostNode= findRightMostNode(leftNode,curr);// finding rightMost node
                
                if(rightMostNode.right==null){
                    rightMostNode.right=curr;
                    curr=curr.left;
                }
                else{
                    rightMostNode.right=null; // breaking the connection first 
                    // then attaching left and right pointer to curr and previous node
                    
                    prev.right=curr;
                    curr.left=prev;
                    prev=curr;
                    
                    curr=curr.right; 
                }
            }
        }
        root=dummy.right;
        dummy.right=null;// detaching dummy node
        prev.right=root;// making circular list
        root.left=prev;
        return root;
        //your code here
    }
    
}
    
