//time complexity is O(n)
// answer will be either x+y or y+x
//where x is the maximum sum of subarray of size x and y is the maximum sum of subarray is size y
//we apply kadane's algo of max sum for size x and y 
// steps
// first create two array of size n 
// one array contains max sum of x size array till that index from LHS
// other array contains max sum of y size array till that index from RHS
// we calculate the sum of x and y x+Y and compare with ans and store it to ans if it is maximum
// similarly again we add max sum of y size array from LHS to the array 
// and we add max sum of x size array from RHS to the other array
// and compare y+x with the previous ans ,if maximum assign y+x to the ans
class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n=nums.length;
        int x[]=new int[n];
        int y[]=new int[n];
        int sum=0;
        // array contain maximum sum of firstlen size subarray till ith index(LHS)
        for(int i=0;i<n;i++){
            if(i<firstLen){// we compare only when we reach to firstLen size
                sum+=nums[i];
                x[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i-firstLen]; // we remove last element 
                x[i]=Math.max(sum,x[i-1]);
            }
        }
        sum=0;
        //array contain maximum sum of secondlen size subarray till ith index(RHS)
        for(int i=n-1;i>=0;i--){
            if(i+secondLen>=n){ //we compare only when we reach to firstLen size
                sum+=nums[i];
                y[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i+secondLen]; //we remove last element 
                y[i]=Math.max(y[i+1],sum);
            }

        }
        int ans=Integer.MIN_VALUE;
        // calculating x+y ans assigning to ans
        for(int i=firstLen-1;i<n-secondLen;i++){
            ans=Math.max(ans,x[i]+y[i+1]);

        }
        sum=0;
        // same as above code but exchange firstLen and secondLen places
        // for Y+X
        //array contain maximum sum of secondlen size subarray till ith index(LHS)

        for(int i=0;i<n;i++){
            if(i<secondLen){
                sum+=nums[i];
                x[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i-secondLen];
                x[i]=Math.max(sum,x[i-1]);
            }
        }
        sum=0;
         // array contain maximum sum of firstlen size subarray till ith index(RHS)
        for(int i=n-1;i>=0;i--){
            if(i+firstLen>=n){
                sum+=nums[i];
                y[i]=sum;
            }
            else{
                sum+=nums[i]-nums[i+firstLen];
                y[i]=Math.max(y[i+1],sum);
            }

        }
        for(int i=secondLen-1;i<n-firstLen;i++){
            ans=Math.max(ans,x[i]+y[i+1]);

        }
        return ans;
        

        
    }
}