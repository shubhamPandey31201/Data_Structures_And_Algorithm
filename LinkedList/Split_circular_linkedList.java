/* Node of a linked list
 class Node {
   int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}
*/
//Time complexity is O(N)
// here we need to split the circular linkedList into two halves 
// the intuition is we need to find mid and split it from there 
// to find mid we keep fast and slow pointer 
// fast moves as fast.next.next while slow moves as slow.next
// when fast.next ==null or fast.next.next ==null  slow will be mid 
// mid.next will be new head and we point mid.next to head1 and fast.next or fast.next.next to head2 based on even or ordd
// since it is circular linked list our loop terminating condition will fast.next!=head && fast.next.next!=head

class gfg
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {
             //DO NOT REMOVE THESE 3 LINES
             Node head=list.head;
             Node head1=null;
             Node head2=null;
             Node fast=head;
             Node slow=head;
             while(fast.next!=head && fast.next.next!=head){
                 fast=fast.next.next;
                 slow=slow.next;
                 
             }
             head1=head;
             head2=slow.next;
             //first circular linkedlist
             slow.next=head1; // since it is circular linked list we point last node to head1 
             if(fast.next==head){ //second circular linked list
                // fast pointer is either last so it has to point to head2
                 
                 fast.next=head2;
                 
                 
             }
             else{
                 // for even no of nodes fast will be second last 
                 
                 fast.next.next=head2;
             }
             
             //Modify these head1 and head2 here, head is the starting point of our original linked list.    
             
             
             //DO NOT REMOVE THESE 2 LINES
             list.head1=head1;
             list.head2=head2;
	 }
}