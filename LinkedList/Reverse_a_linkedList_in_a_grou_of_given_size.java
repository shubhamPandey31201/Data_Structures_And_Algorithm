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
 // Time complexity is O(N)
 // here we need to reverse the linked list in k group . where k is the size of linked list that is needed to be reversed 
 // for example if 1->2->3->4->5 and k=2 that mean length of linked list is divided by k and then reversed 
 // so reversed result will be 2->1->4->3->5
 // first 1 and 2 is reversed and 3 4 is reversed and attach since last group is containing only 5 and its size is 1 which less than 2 hence it is not reversed
 // to solve this problem first find the length of linked list
 // to find length of linked list iterate over linked list and increment the count
 // make an addfirst funtion 
 // addfirst function basically adds new node in the starting of the list
 // run while loop as while(length>=k)
 // length should not go less than k cause it is not reversed 
 // inside outer loop use an inner loop which runs k time 
 // and detach node iteratively and use addfirst function on it
 // maintain 4 pointer one is temphead and temp tail also originalhead and original tail
 class Solution {
    public static ListNode tempHead=null;
    public static ListNode tempTail=null;
    public static ListNode addFirst(ListNode node){
        if(tempHead==null){ // when there is no head then temphead and temptail points same node
            tempHead=node;
            tempTail=node;
        }
        else{
            node.next=tempHead; 
            tempHead=node;// making new node as head
            
        }
        
        return tempHead;
    }
    public static int length(ListNode node){ // finding length of linkedlist
        ListNode currNode=node;
        int len=0;
        while(currNode!=null){
            
            len++;
            currNode=currNode.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<=1){
            return head;
        }
        int len = length(head);
        ListNode currNode=head;
        ListNode originalHead=null;
        ListNode originalTail=null;
        while(len>=k){
            int tempLen=k;
            while(tempLen-->0){
                ListNode forward=currNode.next;// tracking the existence of next node before detaching 
                currNode.next=null;// detaching node
                addFirst(currNode);// adding detached node
                currNode=forward;
                
                
            }
            if(originalHead==null){ // if original head is null that mean first group is reversed 
                originalHead=tempHead;
                originalTail=tempTail;
            }
            else{
                
                originalTail.next=tempHead; // reversing other group rather than first group
                //in this case original head is constant 
                originalTail=tempTail;
            }
            tempHead=null;// after reversing each group updating tempHead and tempTail as null
            tempTail=null;
            len-=k;
        }
        originalTail.next=currNode;// attaching the leftone's  node
        return originalHead;
        
    }
}