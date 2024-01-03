//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java
//Time complexity will be O(n)
// space complexity will be O(k)
// here we need to return the kth smallest element in the array 
// for this we make the max heap in the priority queue of size k
// we iterate through every number if we find the number is lesser than the peek of the queue then we poll and add the number into the queue a
// at last we will get the k smallest element in the queue where first element will be maximum among them
class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        // defining comparator for priority queue
        // max comparator
        Comparator<Integer> com=new Comparator<>(){
            public int compare(Integer a,Integer b){
                // when smallest element comes swap
                if(a<b) return 1;
                else return -1;
            }
            
        };
        PriorityQueue<Integer> pq=new PriorityQueue<>(com);
        // adding first k element in the queue
        for(int i=l;i<k;i++){
            pq.add(arr[i]);
            
        }
    
        for(int i=k;i<=r;i++){
            if(pq.peek()>arr[i]){// if smallest poll and add the element
                pq.poll();
                pq.add(arr[i]);
            }
        }
        
        return pq.peek();
        //Your code here
    } 
}
