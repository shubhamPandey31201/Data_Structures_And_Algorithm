//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
// time complexity is O(N)
// simply make three new Nodes for 0 and 1 and 2 respectively
// attach 0th node to 0th pointer and same for 1 and 2's pointer
// at last attach 0th pointer to firstHead if not empty else to secondHead
// and firstPointer to secondHead
//and secoindPointer to null
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        if(head==null || head.next==null) return head;
        Node zerothHead=new Node(-1);// for 0's
        Node firstHead=new Node(-1);// for 1's
        Node secondHead=new Node (-1);// for 2's
        Node zerothPointer=zerothHead;// pointer for 0
        Node firstPointer=firstHead;// pointer for 1
        Node secondPointer=secondHead;// pointer for 2
        Node currPointer=head;// pointer to original head
        while(currPointer!=null){
            Node forwardPointer=currPointer.next;
            currPointer.next=null;
            if(currPointer.data==0){
                
                
                zerothPointer.next=currPointer;
                
                zerothPointer=zerothPointer.next;
            }
            else if(currPointer.data==1){
                
                firstPointer.next=currPointer;
                
                firstPointer=firstPointer.next;
                
            }
            else{
               
                secondPointer.next=currPointer;
                
                secondPointer=secondPointer.next;
                
            }
            currPointer=forwardPointer;
            
        }
        
        
        zerothPointer.next=(firstHead.next!=null)? firstHead.next:secondHead.next;//attaching Oth list to firshead if not empty else to second list
        firstPointer.next=secondHead.next;// attaching 1'st list to secondHead
        secondPointer.next=null;// attaching 2's list to null
        return zerothHead.next;// zerothHead.next is the actual head;
        
        // add your code here
    }
}


