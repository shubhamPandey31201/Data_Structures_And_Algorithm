import java.util.* ;
import java.io.*; 
// Time complexity is O(N)
// Here we make three array 
// namely ans array, top array , and next array 
// and also a variable called freeSpot
// now at first ans array will have no element
// top array is array array whose size is equal to the number of stack and contains the top of the each stack in terms of index
// initially top of all stack is initialised as zero
// and next array contains the next freeSpot for each index
// initially nextFreeSort will be just next index  for exam of oth index next will be 1th index and for last index nextFreeSpot will be -1 since there is no freeSpot
// also intially freeSpot will be 0th index
public class NStack {
    // Initialize your data structure.
    int[] ans;
    int[] top;
    int[] next;
    int freeSpot;
    
    public NStack(int N, int S) { // this is constructor to initialise all the variable of array and freeSpot
        ans=new int[S];
        top=new int[N];
        next=new int[S];

        for(int i=0;i<N;i++){
            top[i]=-1;

        }
        for(int i=0;i<S-1;i++){
            next[i]=i+1;

        }
        next[S-1]=-1; // last index will have no next freeSpot

        freeSpot=0;

        
        // Write your code here.
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        if(freeSpot==-1){ // check overFlow of the stack when freeSpot is equal to -1 that mean stack is already full
            return false;
        }
        int index=freeSpot; // first to push we need to indentify where to push so we find the index first and index will be the current FreeSpot
        freeSpot=next[index]; // since freeSpot will now we occupied so freeSpot will be updated by next[index] value
        ans[index]=x; // we push the value into the index
        // for updating next we have two conditions 
        // 1st is if the index was already empty then the next value will be the next index to it which we already did while initialising
        // now 2nd is when the index if occupied by the value then we keep the next index of stack that is top value of stack contain the next value(this we do for handeling pop operation)
        next[index]=top[m-1]; // updating next with top since index is occupied with pushed value
        top[m-1]=index; // after pushing top is updated
        return true;
        // Write your code here.
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if(top[m-1]==-1){ // if top of stack is -1 that mean stack is empty so it can not be popped
            return -1;
        }
        int index=top[m-1]; // calculate index which is going to be free now
        top[m-1]=next[index]; // update top of stack with the next[index] since next of index was occupying next in stack(that was previous index)

        next[index]=freeSpot; //since the next of. index is not occupied it will be updated with freeSpot
        
        freeSpot=index;// and freeSpot will be index since its value is popped
        return ans[index];

        // Write your code here.
    }
}