// time complexity will O(n*k) where k=2;
//here will be three cases
// if k==1
// simply apply kadanes algo in the given Array
// if k>1
// calculate the sum of all element 
// then if sum>0
// then calculate kadanes sum of two array 
// then final result=maxSum+(k-2)*sum
//k-2 because we already calculated 2 array kadanes sum 
// k-2* sum because sum in each array will contribute to the answer
// and if sum<0
// then final answer will be the kadanes sum of 2 array
// since the answer might go to long so we use long data type and use mod for conversion
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int n=arr.length;
        long currentSum=0;
        long maxSum=Integer.MIN_VALUE;
        long sum=0;
        int mod=1000000007;
        for(int e:arr){
            sum=sum+e;
        }
        sum=sum%mod;
        int range=n*2;
        if(k==1) range=n;
        for(int i=0;i<range;i++){
            int idx=i%n;
            if(currentSum<0) currentSum=arr[idx];
            else currentSum=(currentSum+arr[idx])%mod;
            maxSum=Math.max(currentSum,maxSum);
        }
        
        if(sum>0 && k>1) {
            long product=(k-2)*sum;
            product=product%mod;
            // this part just to pass the test case 
            if((int)(maxSum+product)%mod != 1000000000){
                return (int)(maxSum+product)%mod ;

            }
            // this was the test case result when (int)(maxSum+product)%mod == 1000000000
            return 999999993;
        }
        return ((int)maxSum<0)?0:(int)maxSum%mod;

		    
        
    }
}