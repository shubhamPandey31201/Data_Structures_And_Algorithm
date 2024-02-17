// Time complexity is O(1)
// space complexity is O(n)
// 80% similar to n stack problem
// here we make 4 arrays 
// answer array to store the values 
// front which stores the front index of each queue
// rear which stores the rear index of each queue
// next which stores the next freeSpot
// freeSpot is the empty spot where any element can be stored.
// in constructor we initialise front and rear with -1 
// where as next as i+1 except last index will contain -1
// in enqueue 
// if freeSpot == -1 that means queue is full so overflow
// find index where element is supposed to be pushed i.e index will be = to freeSpot
// update freeSpot as next[index]
// now check if queue is empty or not if yes both front and rear will have index value
// if queue is not empty next[rear[m-1]]=index
// next[index]=-1;
// rear updated value will be equal to index
// ans[index]=x
// and return true;
// for pop same as stack pop but instead of top use front array
import java.util.* ;
import java.io.*; 
public class NQueue {
	// Initialize your data structure.
	int n;
	int s;
	int ans[];
	int front[];
	int rear[];
	int next[];
	int freeSpot;
	public NQueue(int n,int s) {// initialize arrays
		this.n=n;
		this.s=s;
		ans=new int[s];
		front=new int[n];
		rear=new int[n];
		next=new int[s];
		for(int i=0;i<n;i++){
			front[i]=-1;
			rear[i]=-1;
		}
		for(int i=0;i<s;i++){
			next[i]=i+1;
			

		}
		next[s-1]=-1;
		freeSpot=0;
		// Write your code here.
	}

	// Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
	public boolean enqueue(int x, int m) {
		if(freeSpot==-1){ // overflow condition
			return false;
		}
		
		int index=freeSpot; 
		freeSpot=next[index];//next freeSpot
		
		
		
		
		if(front[m-1]==-1){ // add first element to the queue
			
			front[m-1]=index;
			rear[m-1]=index;
			
		}
		else{
			next[rear[m-1]]=index; // to manage pop the next of  previous value in queue is current index

		}
		next[index]=-1; // for current next will be -1
		rear[m-1]=index;// updating rear index
		ans[index]=x;// adding value
		return true;
		
		
		// Write your code here.
	}

	// Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
	public int dequeue(int m) {
		if(front[m-1]==-1){// underflow
			return -1;

		}
		int index=front[m-1];// removing from front
		if(front[m-1]==rear[m-1]){// for single element case
			
			rear[m-1]=front[m-1]=next[index];
			
		}
		else{
			
			front[m-1]=next[index];// updating front with next[index]
			
			
			
			

		}
		next[index]=freeSpot;// updating next
		freeSpot=index;// updating freeSpot
		int pulled=ans[index];// popping
		return pulled;
		// Write you code here.
	}
};