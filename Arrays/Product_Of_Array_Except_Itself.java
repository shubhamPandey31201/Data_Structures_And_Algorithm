// Time complexity is O(N)
// we calculate leftProduct and rightProduct array
// we calculate leftProduct without making an array
// leftProduct of ith index is the product of all element from start to ith
// rightProduct of ith index is the product from ith index to last index
// create result array result if ith index will be product of left[i-1] and right[i+1]
class Solution {
    public int[] productExceptSelf(int[] nums) {
        //creating rightProduct array
        int [] rightProduct= new int[nums.length];
        
        int mul=1;
        for(int i=nums.length-1;i>=0;i--){
            mul*=nums[i];
            rightProduct[i]=mul;
        }
        mul=1;// for leftProduct
        int [] result=new int[nums.length];
        for(int i=0;i<nums.length-1;i++){
            result[i]=mul*rightProduct[i+1];//result array
            mul*=nums[i];//updating leftProduct
        }
        result[nums.length-1]=mul;// last index will be leftProduct[n-2]
        return result;
        
        
    }
}