//User function template for JAVA

/* Node is defined as

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

// time complexity is O(k*n) where k is the length of the cycle 
// we maintain two node pointer fast and slow 
// fast moves by two steps and slow moves by one step
// if fast and slow meets at some time then it suggests that there exist a loop and we return true 
// if fast.next and fast.next.next meets null then there doesn't exist any looop



class Solution {
    //Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head){
        Node fast=head;
        Node slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){ // fast and slow meets means there exist a loop
                return true;
            }
        }
        return false;
        // Add code here
    }
}