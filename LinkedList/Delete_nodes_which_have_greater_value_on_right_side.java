/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
// time complexity is O(N)
// reverse the list first
// then consider the max val as first node value
// then add first node to the new list
// then whenever the next node is greater than max val
// add that node to the list 
// last return the new head 
class Solution
{
    Node reverse(Node head){// reversing list
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
    Node compute(Node head)
    {
        
        head=reverse(head);
       
        Node currNode=head;
        Node newHead=new Node(-1);
        Node c1=newHead;
        int maxVal=Integer.MIN_VALUE;
        while(currNode!=null){
            if(currNode.data>=maxVal){//whenever node val is greater than maxVal updata maxVal and add node to the new list
                maxVal=currNode.data;
                c1.next=currNode;
                c1=c1.next;
             
            }
            currNode=currNode.next;
         
        }
        c1.next=null;// last node should point to null
        newHead=newHead.next;
        newHead=reverse(newHead);// since list was reverse it is reversed again to get actual answer
        return newHead;
        //your code here
    }
}
  