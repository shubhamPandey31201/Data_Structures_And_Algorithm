// time complexity is O(logn)
// in this question we need to find the smallest element in the sorted rotated array consisting unique element
// here the insight is we need to find the deflection point where deflection point is when arr[mid]>arr[mid+1] or arr[mid-1]>arr[mid]
// the next element to the deflection point will be the minimum element in the array

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        if(nums[low]<nums[high]){ // when array is already sorted
            return nums[0];
        }
        if(nums.length==1){ // when array has only one element then the element itself is the smallest element
            return nums[0];
        }
        // binary search
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1] && mid<nums.length-1){ // fiding deflection point and managing index out of bound exception
                return nums[mid+1];
            }
            else if(nums[mid]<nums[mid-1] && mid>0){// fiding deflection point and managing index out of bound exception
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){// when array is sorted from low to mid then move to unsorted part since deflection point will be found in unsorted part only
                low=mid+1;
            }
            else if(nums[mid]<=nums[high]){ // when array is sorted from mid to high then move to unsorted part since deflection point will be found in unsorted part only
                high=mid-1;
            }
        }
        return -1;
        
    }
}