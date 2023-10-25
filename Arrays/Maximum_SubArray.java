//Time complexity O(N)
// This question uses kadane's algorithm
// we maintain currentSum and bestSum
// At last we return bestSum
// if sum is less than 0 that mean we need to start with another subarray
// since if we add negative number to an array it will automatically reduce the sum despite the number sign 
class Solution {
    public int maxSubArray(int[] nums) {
        int currentSum=nums[0]; //test case [-1] can't add zero to it cause 0>-1
        int bestSum=nums[0];

        for(int i=1;i<nums.length;i++){
            //when currentSum is less than zero then start with new subarray
            if(currentSum<0){
                currentSum=nums[i];
            }
            else{
                // else continue with same subArray
                currentSum+=nums[i];

            }
            // updating bestSum whenever current sum is largest
            
            bestSum=Math.max(currentSum,bestSum);
        }
        return bestSum;
        
    }
}