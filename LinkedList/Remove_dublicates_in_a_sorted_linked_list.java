/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/
// time complexity O(n)
// simpley take two pointer and check if both pointer values are equal or not
// if equal skip the node
// here prev pointer will only move if currNode val is different
class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
        Node prev=head;
        Node curr=head.next;
        while(curr!=null){
            if(curr.data==prev.data){
                curr=curr.next;
            }
            else{
                prev.next=curr;
                prev=curr;
                curr=curr.next;
                
            }
        }
        prev.next=null;
        return head;
	// Your code here	
    }
}
