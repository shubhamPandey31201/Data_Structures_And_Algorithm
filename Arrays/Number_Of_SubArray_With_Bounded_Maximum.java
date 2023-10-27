//Time complexity O(n)
// We make breakPoint and the sum of count of subarray before that breakPoint 
// is the final answer
// breakpoint is the number greater than the range 
// total number of subarray is calculate as n(n+1)/2
// we have three cases for counting subarray
//case 1 when left<=nums[ei]<=right//calculate previousCount and add to resCount
// case 2 when nums[ei]<left // add the previousCount to resCount
// case 3 when nums[ei]>right // we reset
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {


        int previousCount=0;
        int ansCount=0;

        int startingIdx=0;
        int endingIdx=0;

        while(endingIdx<nums.length){

            //case i
            if(left<= nums[endingIdx] && nums[endingIdx]<=right){
                previousCount=endingIdx-startingIdx+1;
                ansCount+=previousCount;
            }
            // case ii
            else if(nums[endingIdx]<left){
                // also it can be endingIdx-startingIdx
                ansCount+=previousCount;

            }
            // case iii
            else{// when nums[endingIdx]> right 
            // reset
                startingIdx=endingIdx+1;
                previousCount=0;

            }
            endingIdx++;
        }
        return ansCount;
        
    }
}