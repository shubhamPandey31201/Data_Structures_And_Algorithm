//time complexity is O(n)
//creating a reverse function
// first we reverse the entire array
// second step is we reverse array upto 0 to k-1 (k items)
// third step is we reverse array from k to n-1 length
class Solution {
    // creating a reverse function

    static void reverse(int[] arr,int sIdx,int eIdx){
        while(sIdx<eIdx){
            int temp=arr[sIdx];
            arr[sIdx]=arr[eIdx];
            arr[eIdx]=temp;
            sIdx++;
            eIdx--;
        }
    }
    public void rotate(int[] nums, int k) {

        //ensure k is within array bounds
        //if k is greater than array size then we use mod operator 
        // since after n rotation the array wiill come back to its starting pos.
        

        k%=nums.length;// edge case

        // incase k is a negative number then
        if(k<0)
            k+=nums.length;
        //reversing entire array

        reverse(nums,0,nums.length-1);
        //reversing first k items

        reverse(nums,0,k-1);
        //reversing  the left items

        reverse(nums,k,nums.length-1);
        
    }
}