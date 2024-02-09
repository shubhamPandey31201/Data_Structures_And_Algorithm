//User function Template for Java
// time complexity is O(N)

class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {   // simply we have to find maximum sum of two element in sub array of size two 
        // so we form window of two element and move it and add sum and compare it with maxSum
        // if current sum is greater than update maxSum
        if(N<2) return -1; // if N is already lesser than 2 that means we can't find sum so -1
        long maxSum=arr[0]+arr[1];// first sum 
        for(int i=1;i<N-1;i++){
            long sum=arr[i]+arr[i+1];// other sum of subarray of size 2(window)
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
        // Your code goes here
    }
    
}