import java.util.* ;
import java.io.*; 
/*********************************************************

    Following is the Binary Tree node structure:

    class Node {
        public int data;
        public Node next;
        public Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
************************************************************/

/*
	Time Complexity: O(N)
	Space Complexity: O(1)
	
	
*/
/* The idea is the same as used in the previous approach . this time we will do it iteratively
   1. head is pointing to the first note of the linked list
   2. Initialise apointer to a Node 'NEW_HEAD' that will point to the head of the final modified linked list
   3. Repeat the steps until all the nodes are processed in the same way.
    . reverse the first K nodes of the linked list.
    . after reversing the K nodes the head points to the kth node
    . if the newHead is null
      .if the kth node in the original linked list exists, it will be the new_head
      . else the last node in the original liked list will be the New_head
    . To conned the reversed part with the remaining part of the linked list,
      update the next of the head to (K+1)th node and the previous of the (k+1)th node to the head node
    . return the new head of the linked list
    . Note that we just set newhead once
*/

	
public class Solution {
    public static Node reverseDLLInGroups(Node head, int k) {
        Node last = null, curr = head, ahead = null; 
	    Node tail = null, join = null; 
	    
	    Node newHead = null; 
	    int count = 0; 
	  
	    // Traverse the linked list to the end.
	    while (curr != null) 
		{ 
	        count = k; 
	        join = curr; 
	        last = null; 
	  
	        // Reversing the k nodes.
	        while (curr != null && count > 0) 
			{ 
	            ahead = curr.next; 
	            curr.next = last;
	            if(last != null)
	            {
	            	last.prev = curr;
	            }
	            last = curr; 
	            curr = ahead; 
	            count -= 1;
	        } 
	  
	        // Update the new head for the modified linked list.
	        if (newHead == null) 
	        {
	            newHead = last; 
	        }
	  
	        //  Tail pointer is joined with the first node of the remaining linked list.
	        if (tail != null)
	        {
	            tail.next = last; 
	            last.prev = tail;
	        }
	        
	        // Updating tail for the next iteration. 
	        tail = join;  
	    } 
	  
	    // New head of the modified list is returned.
	    return newHead;
    }
}
