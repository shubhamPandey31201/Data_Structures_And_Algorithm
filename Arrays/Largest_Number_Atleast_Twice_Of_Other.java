// time complexity O(N)
// if a largest number is greater than 2 times second largest number then return index of largest number
// else return -1;
// find largest and second largest number then check condition and return
class Solution {
    public int dominantIndex(int[] nums) {
        int max1= Integer.MIN_VALUE;
        int max2=max1;
        int maxIdx=-1;

        

        for(int i=0;i<nums.length;i++){

            //finding largest and second largest number
            if(nums[i]>max1){
                max2=max1;
                max1=nums[i];
                maxIdx=i;
            }
            else if(nums[i]>max2){
                max2=nums[i];
            }
        }
        // checking whether largest number is twice of 2nd largest number
        if(max1>=max2*2){
            // returning the maximum index
            return maxIdx;
        }
        return -1;
    }
}