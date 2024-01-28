//time complexity is O(logn);
// in this question we need to find an element in the sorted rotated array consisting repeating element
// in this question we might face a case where we can't which part of array is sorted
// and this case happens when arr[low]==arr[mid]==arr[high]
// so we check if arr[low]==arr[mid]==arr[high] is equal to target or not 
// if yes return the element and if not we decrease the search area by incrementing low by 1 and decrementing by 1
// then onwards check for sorted part and unsorted part and according to the target either search in sorted or unsorted part
class Solution {
    public boolean search(int[] nums, int target) {

        int low=0;
        int high = nums.length-1;
        

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]== target || nums[low]==target || nums[high]==target){// when element is found
                return true;
            }
            else if(nums[low]<=nums[mid] && nums[mid]>nums[high]){ //when array is sorted from low to high 
                if(nums[low]<=target && target<=nums[mid]){// when target lies in sorted part
                    high=mid-1;
                }
                else{// when target lies in unsorted area
                    low=mid+1;
                }
            }
            else if(nums[mid]<=nums[high] && nums[low]>nums[mid] ){ // when array is sorted from mid to high
                if(nums[mid]<=target && target<=nums[high]){// when target lies in sorted area
                    low=mid+1;
                }
                else{// when target lies in unsorted area
                    high=mid-1;
                }

            }
            else{ // arr[low]==arr[mid]==arr[high] is not equal to target decreasing the search area
                low++;
                high--;
            }
        }
        return false;
        
    }
}