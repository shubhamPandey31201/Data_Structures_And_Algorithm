//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */
// time complexity is O(nlogn)
// recursing is used 
// find mid node 
// then detach the list from mid.next onwards
// then call same function from head 
//again call same function from mid.next as newHead
// then merge both node
// keep base case has head==null or head.next==null return head
// for merging apply same logic as in array merging
// create a new list and start attacting smallest node

class Solution
{
    static Node findMid(Node head){// finding mid
        if(head==null || head.next==null){
            return head;
        }
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    
    }
    static Node merge(Node head1,Node head2){// merging two halves of list
        Node c1=head1;// first half
        Node c2=head2;// second half
        Node newHead= new Node(-1);// new list
        Node prevNode=newHead;// pointer to new list
        while(c1!=null && c2!=null){
            if(c1.data<c2.data){
                prevNode.next=c1;
                c1=c1.next;
                prevNode=prevNode.next;
            }
            else{
                prevNode.next=c2;
                c2=c2.next;
                prevNode=prevNode.next;
            }
        }
        while(c1!=null){// left one nodes of first half list
            prevNode.next=c1;
            c1=c1.next;
            prevNode=prevNode.next;
        }
        while(c2!=null){// left one nodes of second half list
            prevNode.next=c2;
            c2=c2.next;
            prevNode=prevNode.next;
        }
        newHead=newHead.next;// since newHead at starting was pointing to -1 
        return newHead;
    }
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){ // base case 
            return head;
        }
        Node mid=findMid(head);// finding mid
        Node nHead=mid.next;// new head is mid.next
        mid.next=null;// detaching list into two halves
        Node head1=mergeSort(head);// recursion call for first half
        Node head2=mergeSort(nHead);// recursion call for second half
        Node newHead=merge(head1,head2);// merging both halves
        return newHead;
        // add your code here
    }
}


