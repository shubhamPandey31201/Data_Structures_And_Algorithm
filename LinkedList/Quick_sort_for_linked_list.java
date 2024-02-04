/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
    
}*/
// you have to complete this function
// worst time complexity will be O(n^2)
// best time complexity will be O(nlogn)
// quick sort linkedlist includes few step
// finding length of the list
// considering pivot index as mid index so length/2 

// segregating list into three parts left sorted list , pivot node and right sorted list
// while segregating find pivotNode using while loop
// then segreate and return into array
// then we do recursive call for first half
// we do recursive call for second half
// and merge it 
// and return the head


class GfG
{
    public static Node[] segregate(Node head, int pivotIndex){
        Node pivotNode=head;
        Node smallHead=new Node(-1);// for left smaller list
        Node sp=smallHead;
        
        Node largeHead=new Node(-1);// for right smaller list
        Node lp=largeHead;
        Node currNode=head;
        while(pivotIndex-->0){ // for finding pivotNode
            pivotNode=pivotNode.next;
        }
        
        while(currNode!=null){ // for segregating traverse to each node
            if(currNode!=pivotNode){ // for skipping pivotNode
                if(currNode.data<=pivotNode.data){ // attaching smaller element to smallHead
                    sp.next=currNode;
                    sp=sp.next;
                }
                else{// attaching larger element to largeHead
                    lp.next=currNode;
                    lp=lp.next;
                }
            }
            currNode=currNode.next;
            
        }
        sp.next=null;// seperating left half from original list
        lp.next=null;// seperating right half from original list
        pivotNode.next=null;// seperating pivot node from original list
        return new Node []{smallHead.next,pivotNode,largeHead.next};// return all three seperated node heads
    }
    // finding length of original list
    public static int length(Node head){
        if(head==null) return 0;
        Node currNode=head;
        int len=0;
        while(currNode!=null){
            len++;
            currNode=currNode.next;
        }
        return len;
    }
    
    public static Node[] merge(Node[] lsl,Node pivotNode,Node[] rsl){// this will return head and tail of merged list
        Node head=null;
        Node tail=null;
        // there will four cases 
        // first is when lsl and rsl both are not null
        // second is when lsl is null but rsl is not null
        // third is when lsl is not null but rsl is null
        // four case is when both lsl and rsl is null
        
        if(lsl[0]!=null && rsl[0]!=null){// first is when lsl and rsl both are not null
            lsl[1].next=pivotNode;
            pivotNode.next=rsl[0];
            head=lsl[0];
            tail=rsl[1];
        }
        else if(lsl[0]==null && rsl[0]!=null){// second is when lsl is null but rsl is not null
            pivotNode.next=rsl[0];
            head=pivotNode;
            tail=rsl[1];
        }
        else if(lsl[0]!=null && rsl[0]==null){ // third is when lsl is not null but rsl is null
            lsl[1].next=pivotNode;
            head=lsl[0];
            tail=pivotNode;
        }
        else{// four case is when both lsl and rsl is null
            head=pivotNode;
            tail=pivotNode;
        }
        return new Node[] {head,tail}; // return head,tail
        
    }
    public static Node[] quickSort_(Node node) // return head and tail
    {
        if(node==null || node.next==null){
            return new Node[]{node,node}; // when single element or not element is there head and tail both are same only 
        }
        int len=length(node);
        int pivotIdx=(len/2);
        Node[] segregatedArr=segregate(node,pivotIdx); 
        Node[] leftSortedList=quickSort_(segregatedArr[0]);// recursion call for left half that returns head and tail of list
        Node[] rightSortedList=quickSort_(segregatedArr[2]);// recursion call for right half that returns head and tail of the list
        
        return merge(leftSortedList,segregatedArr[1],rightSortedList);// merging also returns head and tail of merged list
        
        
        //Your code here
    }
    public static Node quickSort(Node node){
        Node newHead=quickSort_(node)[0];// at Oth index head of the list is present so that is returned
        return newHead;
    }
    
    
}