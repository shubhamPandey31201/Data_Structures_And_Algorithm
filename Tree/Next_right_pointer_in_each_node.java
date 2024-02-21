/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Time complexity is O(n)
//  here there is extra space for next pointer
// next pointer points to next node in the same level of the tree
// we need to add nodes to next pointer in this question
// the intuition is for currentNode we connect for currentNode children
// such that currentNode.left.next=currentNode.right
// and currentNode.right.next=currentNode.next.left
// before pointing for currentnode's right's next we check if currentNode.next == null or not if it is we break from loop
// also we maintain a node variable that contain first left node of each level
// after every level traversal we traverse to next level using this node only

class Solution {
    public Node connect(Node root) {
        if(root==null) return root;
        Node tempNode=root; // for traversing to other level's first left node
       
        
        while(tempNode!=null && tempNode.left!=null){
            Node currNode=tempNode;// for travering in level only  
            while(true){
                currNode.left.next=currNode.right; // attaching left's next
                if(currNode.next==null) break;// handeling null pointer exception
                
                currNode.right.next=currNode.next.left; // attaching right's next
                
                currNode=currNode.next; // traversing to sibling node in same level
            }
            tempNode=tempNode.left;// traversing to first left node of different level

        }
        return root;
        
    }
}