//User function Template for Java
//time complexity is O(N)
// Sliding window protocol
// add the negative number from first k element from the array
// first add top of the queue to array if its not empty 
// if its empty then add zero to the array
// N-k+1 will be new array size 
// first check if the queue peek is equal to the first element of the window  if its is equal pop it
// and add the new element to the queue

class Compute {
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> que=new LinkedList<>();
        for(int i=0;i<K;i++){// add first three negative element
            if(A[i]<0)
                que.add(A[i]);
        }
        long [] arr=new long[N-K+1];
        arr[0]=(que.isEmpty())?0:que.peek();
        for(int i=1;i<N-K+1;i++){ // from second window to last window
           
            if(A[i-1]<0){ // if previous first element was negative that is why it is popped out
                que.poll();
            }
            if(A[i+K-1]<0){ // add if new last element of window is negative
                que.add(A[i+K-1]);
            }
            arr[i]=(que.isEmpty())?0:que.peek(); // if queue size is empty that means there is no negative element in the window so add zero or add peek of the queue
        }
        return arr;
    }
}