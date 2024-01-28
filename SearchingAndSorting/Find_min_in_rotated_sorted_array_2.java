// time complexity is O(logn)
// in this question we need to find the smallest element in the sorted rotated array consisting repeated element
// here the insight is we need to find the deflection point where deflection point is when arr[mid]>arr[mid+1] or arr[mid-1]>arr[mid]
// the next element to the deflection point will be the minimum element in the array
// also array consist of repeated element so there might be a case where 
//arr[mid]==arr[high]
// so we decrease the searching area by decrementing high by 1

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        
        int high=nums.length-1;
        
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==nums[high]){ // decrementing search area
                high--;
            }
            else if(nums[mid]<nums[high]){ // mid to high is sorted part so moving towards unsorted part i.e low to mid
                high=mid;
            }
            else { // low to mid is sorted part so moving towards unsorted part i.e mid to high
                low=mid+1;
            }
        }
        return nums[low];
        
    }
}