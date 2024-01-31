//User function Template for Java


/* class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}*/
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
// once fast and slow meets 
// set slow as head 
// and now run loop until fast and slow meets
// this time both fast and slow will move one step forward 
// the point they meet this time will be the first node
// there is a mathematical proof so refer notebook
class Solution {
    //Function to find first node if the linked list has a loop.
    public static int findFirstNode(Node head){
        if(head==null || head.next==null){
            return -1;
        }
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){// first meeting point
                break;
            }
        }
        if(slow!=fast){ // when slow and fast don't meet means there is no cycle
            return -1;
        }
        slow=head;
        fast=fast;
        while(fast != slow){// second meeting point is the answer
            fast=fast.next;
            slow=slow.next;
        }
        return slow.data; 
        //code here
    }
}