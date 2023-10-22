// Time complexity O(n);
// we don't need to sort the array
// instead we find min1 and min2 
// also max1,max2 and max2
// since product of min1 and min2 can give positive number 
// if it is multiplied with highest number that is max 1 can give max product
// so we calculate max2,max3 product and min1 and min2 product
// whichever product is maximum is multiplied to the max number and then returned
class Solution {
    public int maximumProduct(int[] nums) {
        int min1, min2, max1, max2, max3;
        min1 = min2 = Integer.MAX_VALUE;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){

            //calculating max1,max2,max3
            if(max1 <= nums[i]){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(max2 <= nums[i]){
                max3 = max2;
                max2 = nums[i];
            }else if(max3 <= nums[i]){
                max3 = nums[i];
            }
            //calculating min1 and min2
            

            if(min1 >= nums[i]){
                min2 = min1;
                min1 = nums[i];
            }else if(min2 >= nums[i]){
                min2 = nums[i];
            }
            
        }
        //returning max prduct with max1 value
        return Math.max(max1 * max2 * max3 , min1 * min2 * max1);
    }
}