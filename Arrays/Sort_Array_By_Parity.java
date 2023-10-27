// Time complexity O(N)
// Same logic as Segregate O and 1
// two pointer i and j 
// two area 0 to j-1 for evens
// j to i-1 for odds
// two cases 
// case 1 nums[i] is even swap and i++, j++
// case 2 nums[i] is odd increment i++;
class Solution {
    // swapping function
    static void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int i=0;
        int j=0;
        while(i<nums.length){
            if(nums[i]%2==0){ // case i for even
                swap(nums,i,j);
                i++;
                j++;
            }
            else{ // case 2 for odd 
                i++;
            }
        }
        return nums;

        
    }
}
