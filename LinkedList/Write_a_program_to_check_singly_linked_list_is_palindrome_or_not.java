/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
// Time complexity is O(N)
// here first we find Mid using fast and slow pointer
// after we find the mid from Mid.next we reverse the list 
// then from head to mid and from mid.next to tail we compare the value 
// if its not equal return false else return true


class Solution
{
    static Node findMid(Node head){// finding mid node
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
        
    }
    static Node reverseLL(Node head){// reversing list
        Node previousNode=null;
        Node currNode=head;
        Node forwardNode=null;
        while(currNode!=null){
            forwardNode=currNode.next;
            currNode.next=previousNode;
            previousNode=currNode;
            currNode=forwardNode;
        }
        head=previousNode;
        return head;
    }
    //Function to check whether the list is palindrome.
    boolean isPalindrome(Node head) 
    {
        Node mid=findMid(head);
        Node newHead=mid.next;
        mid.next=null;// detaching list into two halves
        newHead=reverseLL(newHead);// reversing list from newhead
        Node c1=head;
        Node c2=newHead;
        boolean res=true;
        while(c1!=null && c2!=null){
            if(c1.data!=c2.data){// when data's of two corresponding nodes are not equal its not palindrome 
                res=false;;
            }
            c1=c1.next;// iterating first half
            c2=c2.next;// iterating second half
        }
        newHead=reverseLL(newHead); // again reversing to make list same as original list
        mid.next=newHead;// attaching two halves of list
        return res;
        //Your code here
    }    
}

