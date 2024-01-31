class LinkedList{
    public Node head;
    class Node{
        int data;
        Node next;


        Node(int data){
            this.data=data;
            this.next=null;

        }
    }
    
    public void addFirst(int data){
        Node newNode =new Node(data);
        if(head==null){
            head=newNode;
            return ;

        }
        newNode.next=head;
        head=newNode;
        
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }
    public void print(Node head){
        if(head==null){
            System.out.println("null");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode=currNode.next;
        }
        System.out.print("null");
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("no element to delete");
            return;

        }
        head=head.next;
        

    }
    public void deleteLast(){
        if(head==null){
            System.out.println("no element to delete");
            return;
        }
        Node currNode=head;
        while(currNode.next.next!=null){
            currNode=currNode.next;
        }
        currNode.next=null;
    }


    
}
public class Linked_list_implementation{
    
    public static void main(String[] args){
        LinkedList l1=new LinkedList();
        l1.addFirst(3);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.addLast(4);
        l1.addLast(5);
        l1.addLast(6);
        l1.deleteFirst();
        l1.deleteLast();
        l1.print(l1.head);
        
    }
}