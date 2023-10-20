/*question is to find the number that has largest occurence in the array 
 such that the number is occurence is greater than the half of the size of the 
 array . if the case is not satisfied return -1 */

//Time complexity of this program is O(n)

// steps we take first element as a ans value and keep its count as 1
// we check for next element if it is same as val we increment it as 1 else
// we have two condition to check if the count for that number is 0 then we change the value with current index number and keep count as 1 else we decrement the count
// from this step we get the number that has highest occurence 
// now we check if that value occurence is greater than half of the size of array or not
class Solution {
    public int majorityElement(int[] nums) {
        int val=nums[0]; // initializing val with the first element 
        int count=1; // maintaining the count of val
        
        for(int i=1;i<nums.length;i++){
            // finding the number that has highest occurence
            if(nums[i]==val){
                count++;
            }
            else{
                if(count==0){
                    val=nums[i];
                    count=1;
                }
                else{
                    count--;
                }
            }

        }
        /* checking if the highest occurence number count is more than half of 
        the size of array or not*/
        count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                count++;
            }
        }
        if(count>nums.length/2){
            return val;
        }
        return -1;
        
    }
}