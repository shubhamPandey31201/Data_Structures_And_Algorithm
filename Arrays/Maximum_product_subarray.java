// time complexity is O(n)
// using kadane's  also 
// we can get the answer from either traversing from left to right or right to left
// whenever there is 0 in between of the array currentProduct will be reset to 1
// bestProduct will be updated every time with currentProduct
// a()b lets say a and b is the sub array and in between is the sub array
// here arises four cases
// if a and b both are positive then if () is + entire array is the answer if () is - then greatest of a and b will be the answer 
// if a is positive and b is negative if () is + then product of a and () will be the answer and if () is - product of () and b will be the answer
// if a is negative and b is positive , if() is - then product of a and () will be the answer and if () is positive then product of b and () will be the answer
// if a and b both are negative , if () is + then entire product of array will be the answer and if () is - then greatest among a and b will be the answer
// that is why we calculate product from right and left as well
class Solution {
    public int maxProduct(int[] nums) {
        int bestProduct=Integer.MIN_VALUE;
        int currentProduct=1;
        for(int i=0;i<nums.length;i++){
            currentProduct*=nums[i];
            bestProduct=Math.max(currentProduct,bestProduct);
            if(currentProduct==0){
                currentProduct=1;
            }

        }
        currentProduct=1;
        for(int i=nums.length-1;i>=0;i--){
            currentProduct*=nums[i];
            bestProduct=Math.max(currentProduct,bestProduct);
            if(currentProduct==0){
                currentProduct=1;
            }

        }
        return bestProduct;
        
    }
}