/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*
class Node {
    int data;
    Node next, arb;

    Node(int d) 
    { 
        data = d;
        next = arb = null; 
        
    }
}*/

// Time complexity is O(N)
// here deepcopy means coping with complete different address such that change in copy material won't affect the original one
// where as in shallow copy copy material points same address and change in shallow copy results in change of original content
// in this question we need to do deepcopy of linked list with random pointer
// to do this we need to make a complete different list 
// first we make new Node with -1 as new head
// then we run loop over original list and copy nodes with next pointer 
// also while copy we maintain Hashmap with original and copied node for future use in random pointer
// once linkedList is copied without random pointer and hashmap is maintained 
// we iterate over newhead and with the help of hashmap we find the random pointer and connect to the copied node



class Clone {
    //Function to clone a linked list with next and random pointer.
    Node copyList(Node head) {
        Node newHead=new Node(-1);// creating new head
        Node currNode=head;// pointer to original list
        Node currNewTemp=newHead;// pointer to new list
        HashMap<Node,Node> copy=new HashMap<>(); // hashmap contain key as original node and value as copied node
        while(currNode!=null){ // coping list with next pointer first and adding copied node to hashmap
            int val=currNode.data;
            Node newNode=new Node(val);// creating new node (deepcopy)
            
            currNewTemp.next=newNode; //attacting new node in copy list
            copy.put(currNode,newNode);// adding to hashmap
            currNewTemp=currNewTemp.next;//iterating new list
            currNode=currNode.next;// iterating original list
           
            
            
            
        }
        newHead=newHead.next;// since newhead was pointing to -1 to next to -1 node is actual head
        currNode=head; // pointer to original list
        currNewTemp=newHead; // pointer to new list
        while(currNewTemp!=null){ // iterating over new list
            Node tempNode=(currNode.arb!=null)?copy.get(currNode.arb):null; // using hashmap finding random pointer node if there is null then attach null 
            currNewTemp.arb=tempNode;// adding random pointer to new list
            currNode=currNode.next;// iterating original list
            currNewTemp=currNewTemp.next;// iterating copied list
            
        }
        return  newHead;
        
        // your code here
    }
}

