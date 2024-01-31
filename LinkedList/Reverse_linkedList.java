/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 //Time complexity will be O(n)
 // here we need to maintain three pointer variable 
 // a previous node pointer , a current node pointer and a forward node pointer
 // initially previous node pointer will be null , current node pointer will be head and foward node pointer will be null
 // run a while loop until the current node pointer is not equal to null 
 // in every itertion first calculate forward node i. current node .next
 // then de-attach currrent node by point next to null 
 // after de-attaching point current node to previous node 
 // then make previous node as current node and current node as foward node
 // at last previous node will be the head of the list
 class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previousNode=null;
        ListNode currentNode=head;
        ListNode forwardNode=null;
        if(head==null || head.next==null){
            return head;
        }
        while(currentNode!=null){
            forwardNode=currentNode.next; // taking note of forward node so that after de-attaching it does not get lost
            currentNode.next=previousNode; // attaching current Node to previous node
            previousNode=currentNode; // moving previous node
            currentNode=forwardNode;// moving current node
            
        }
        head=previousNode; // previous Node will point the last node of the list after the end of loop hence it will be the head of the reverse loop
        return head;
        
    }
}