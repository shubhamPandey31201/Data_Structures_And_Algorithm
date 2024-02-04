import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Node class:

      class Node<T> {
    	T data;
    	Node<T> next;
    	Node<T> prev;

    	public Node(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/
// Time complexity(nlogK)
// since k is there so priority queue is used 
// here min priority queue has been used
//first add k+1 element to the queue
// then run loop until queue is not empty
// then check if newhead is null or not 
// if newhead is null then add top of queue as newhead
// if not add top of queue to the next of currPointer of newList
// after adding the node to list poll it out from queue
// andcheck if pointer to original list is null or not if not  add another node to queue
//return newHead

public class Solution {
	// min comparator
	static Comparator<Node<Integer>> min=new Comparator<Node<Integer>>(){
		public int compare(Node<Integer> a, Node<Integer> b){
			if(a.data>b.data){
				return 1;
			}
			return -1;
		}

	};

	public static Node<Integer> sortedDll(Node<Integer> head, int k) {
		// min heap priority queue
		PriorityQueue<Node<Integer>> pq=new PriorityQueue<>(min);
		int i=0;
		
		Node<Integer> newHead=null;
		Node<Integer> c1=null;
		// first store k+1 node in priority queue 
		
		Node<Integer> newPointer=newHead;
		while(i++<=k && head!=null){
			pq.add(head);
			head=head.next;

		}
		// then run loop till queue is not empty
		while(pq.size()>0){
			if(newHead==null){// for adding first element to new list
				newHead=pq.peek();
				newHead.prev=null;
				c1=newHead;

			}
			else{
				c1.next=pq.peek();
				pq.peek().prev=c1;
				c1=c1.next;
			}
			pq.poll();// removing the top of queue
			if(head!=null){ // adding node to queue 
				pq.add(head);
				head=head.next;
			}
		}
		c1.next=null;// last node should point to null
		return newHead;
		// Write your code here.
	}

}