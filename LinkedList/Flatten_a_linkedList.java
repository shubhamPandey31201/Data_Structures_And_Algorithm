/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
// time complexity is O(N)
// in this question we have to node pointers one is next and other is bottom
// to ever node bottom pointer is a separate list 
// the question is to flatten the list such that 
// all the nodes are sorted in bottom pointer of the head node
// to do this we apply merging algorithm 
// first we go to the last two nodes with next pointer
// then bottom with we sort two list and form another next node
// then again two nodes are sorted  and same process continues on 
// untill single head is not obtained with next pointer as null 
// and bottom pointer with another node


class GfG
{
    Node merge(Node head1, Node head2){
        Node newHead=new Node(-1);// creating another list 
        Node currNode=newHead;// pointer from newHead
        Node currNode1=head1; 
        Node currNode2=head2;
        // merging two lists of head1 and head2
        if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        while(currNode1!=null && currNode2!=null){
            if(currNode1.data<currNode2.data){
                currNode.bottom=currNode1;
                currNode=currNode.bottom;// bottom wise sorting is asked in the question
                currNode1=currNode1.bottom;
            }
            else{
                currNode.bottom=currNode2;
                currNode=currNode.bottom;
                currNode2=currNode2.bottom;
            }
        }
        while(currNode1!=null){
            currNode.bottom=currNode1;
            currNode=currNode.bottom;
            currNode1=currNode1.bottom;
            
        }
        while(currNode2!=null){
            currNode.bottom=currNode2;
            currNode=currNode.bottom;
            currNode2=currNode2.bottom;
            
        }
        currNode.bottom=null;
        newHead=newHead.bottom;
        
        return newHead;
    }
    Node flatten(Node root)
    {
        // This recursive call should be understood nicely
        if(root==null || root.next==null){ // returning last next node
            return root;
        }
        root.next=flatten(root.next);//
        root=merge(root,root.next);// merging last two heads
        return root;// return root;
	// Your code here
    }
}