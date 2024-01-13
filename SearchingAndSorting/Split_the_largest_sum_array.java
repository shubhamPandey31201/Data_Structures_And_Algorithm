// similar to capacity to ship package
//Time complexity is O(nlogn)
//we need to find  the minimum sum  to divide into k Subarray
// whenever minimization problem comes think of binary search first
// here  since 1<=k<=nums.length
// so for low value will be the maximum sum in the array for k subarrays
// and high will be the sum of array for 1 days
// we calculate mid each time 
// for each mid(temp limit) value we calculate k subarrays if calculated subarrays is greater then low=mid-1 else mid+1



class Solution {
    public int splitArray(int[] nums, int k) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        // finding max and sum of array
        for(int e:nums){
            max=Math.max(e,max);
            sum+=e;
        }
        if(k==nums.length) return max;

        int low=max;
        int high=sum;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            int tempK=1;
            sum=0;
            // calculating tempK 
            for(int e:nums){
                if(sum+e>mid){
                    tempK++;
                    sum=e;

                }
                else{
                    sum+=e;
                }
            }
            if(tempK<=k){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;

            }

        }
        return ans;
        
    }
}