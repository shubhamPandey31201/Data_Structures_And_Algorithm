/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
 Linked List class
class LinkedList
{
    Node head;  // head of list
}*/
// time complexity is O(N)
// floyd cycle algorithm is used 
// first we find the last node from traversing from either of the head
// then lastNode.next is attached to head2
// this step will from a cycle 
//then apply algorithm of finding first node of the cycle
// the first node will be the point of intersection 
// at last remove the connection between last node and head2
// also check if last node of both head is same or not 
// if not same that means there doesn't exist any intersection

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
	    if(head1==null || head2==null) return -1;
	    Node currNode=head1;
	    while(currNode.next!=null){ // finding last node from head1
	        currNode=currNode.next;
	    }
	    Node currNodeforhead2=head2;
	    while(currNodeforhead2.next!=null){// finding last node from head2
	        currNodeforhead2=currNodeforhead2.next;
	    }
	    if(currNodeforhead2!=currNode) return -1; // checking if last node from both heads are same or not
	    currNode.next=head2;// forming cycle 
	    Node fast=head1;
	    Node slow=head1;
	    if(fast==null || fast.next==null) return -1;
	    while(fast.next!=null && fast.next.next!=null){
	        fast=fast.next.next;
	        slow=slow.next;
	        if(fast==slow){ // first meeting point
	            break;
	        }
	    }
	    slow=head1;
	    fast=fast;
	    while(slow!=fast){// second meeting point will be the answer
	        fast=fast.next;
	        slow=slow.next;
	    }
	    currNode.next=null;
	    return slow.data;
         // code here
	}
}


