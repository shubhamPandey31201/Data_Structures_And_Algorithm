// time complexity is o(logn)
// in this question we need to find an element in the sorted rotated array consisting unique element
//insight of this question is half of the part of the given array will always be sorted i.e either from low to mid or from mid to high 
// so for each mid point we check the sorted part and also check if the target falls in sorted part or an unsorted part
// and accordingly we decrease the search area

class Solution {
    public int search(int[] nums, int target) {
        int low=0;
        int high = nums.length-1;
        

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){ // when element is found
                return mid;
            }
            else if(nums[low]<=nums[mid]){ // sorted part from low to mid
                if(nums[mid]>=target && nums[low]<=target){ // when target falls in sorted part
                    high=mid-1;
                }
                else{ // when target falls in unsorted part
                    low=mid+1;
                }
            }
            else if(nums[mid]<=nums[high]){// when sorted part is from mid to high
                if(nums[mid]<=target && nums[high]>=target){// when target falls in sorted area
                    low=mid+1;
                }
                else{// when target falls in unsorted area
                    high=mid-1;
                }
            }
        }
        return -1;
        
        
    }
}