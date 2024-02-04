
/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
//Time complexity is O(N)
// first reverse both the list and then apply
// simple addition logic on both list 
// findout digit and carry after each addtion of two nodes
// and create and new node with new digit and attach it to new list



class Solution{
    static Node reverse(Node head){ // reversing list
        Node prev=null;
        Node curr=head;
        Node forward=null;
        while(curr!=null){
            forward=curr.next;
            
            curr.next=prev;
            prev=curr;
            curr=forward;
        }
        return prev;
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // code here
        // return head of sum list
        Node c1=reverse(first);
        Node c2=reverse(second);
        int carry =0;
        Node newHead=new Node(-1);// for new list
        Node itr=newHead;
        while(c1!=null || c2!=null || carry!=0){ // it stop when both c1 and c2 is null and carry is also 0
            int sum=((c1!=null)?c1.data:0) + ((c2!=null)?c2.data:0) + carry;
            int digit=sum%10;
            carry=sum/10;
            itr.next=new Node(digit);
            itr=itr.next;
            
            if(c1!=null) c1=c1.next;
            if(c2!=null) c2=c2.next;
            
            
        }
        newHead=newHead.next;
        newHead=reverse(newHead);// addion was in reverse order to it is reversed again 
        return newHead;
        
    }
}