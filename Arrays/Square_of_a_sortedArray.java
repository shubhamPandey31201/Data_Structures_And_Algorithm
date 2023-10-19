//this question can be solved using two pointer algorithm
// time complexity will be O(n)
//points to focus is given array is in non-decresing order
//it contains negative number also but square of negative number is still positive
//so we use math.abs method to make is postive
class Solution {
    public int[] sortedSquares(int[] nums) {

        int n=nums.length;
        //creating a resultant array
        int ans[]=new int[n];
        //initializing both pointers
        int i=0,j=n-1;
        //whichever pointer's  value is greater will have greater square number
        // hence larger will be added at the last of the array
        for (int k=n-1;k>=0;k--){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                ans[k]=nums[i]*nums[i];
                i++;
            }
            else{
                ans[k]=nums[j]*nums[j];
                j--;
            }
        }
        return ans;
        
    }
}