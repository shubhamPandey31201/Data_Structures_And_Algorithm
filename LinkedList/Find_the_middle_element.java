/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
//Time Complexity is O(N)
// here we maintain two pointer one is slow pointer and other is fast pointer
// the fast pointer will move twice the step of slow pointer
// such that fast = fast.next.next
// and slow=slow.next;
// when fast pointer reaches the last node of the list 
// slow pointer will reach to the middle node of the list 
// there are two cases for middle node
// one for even no of node and other for odd no of nodes
// in case of even fast.next.next will be null and we stop here 
// in case of odd fast.next will be null and we stop here 

class Solution
{
    int getMiddle(Node head)
    {
        Node fastNode=head;
        Node slowNode=head;
        if(head==null){
            return head.data;
        }
        if(head.next==null){
            return head.data;
        }
        while(fastNode.next!=null && fastNode.next.next!=null){ // cause of even no of nodes might throw error
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
        }
        if(fastNode.next==null){ // if odd no of nodes are present
        // at first we should check for odd no of nodes only cause it will throw null pointer exception when we check for even no of nodes 
        
            return slowNode.data;
        }
        return slowNode.next.data; // if even no of nodes are present
         // Your code here.
    }
}
