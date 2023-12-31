// time complexity O(n)
// we have been given two array
// our task is to make either of the array such a way that all the elements are same
// we do that by swapping element from either top or bottom array
// we have four cases 
// one case is making top array same with num1 
// second case is making bottom array same with num1
// third case is making top array same with num2
// fourth case is making bottom array same with num2
// where num1=tops[0] and num2=bottoms[0];
// if we cannot make the array of same element we return -1
// and if we make it than we return the count of minimum number of swaps
// we considered first element of top and bottom array as num1 and num2 because if either of the element is not there in the array in both top and bottom then 
// anyhow our result will be -1 only 
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int num1 = tops[0];
        int num2 = bottoms[0];

        // Case 1 : Replace the top row with num1
        for(int i = 0;i<tops.length;i++){
            if(count1 != Integer.MAX_VALUE){ // when we cannot swap  here no point of traversing again
            if(tops[i] == num1){
                
            }
            else if(bottoms[i] == num1){ // when we can swap
                count1++;
            }
            else{
                count1 = Integer.MAX_VALUE; // when we cannot swap
            }
        }
        }

        // Case 2 : Replace the bottom row with num1
        for(int i = 0;i<bottoms.length;i++){
        if(count2 != Integer.MAX_VALUE){//when we cannot swap  here no point of traversing again
            
            if(bottoms[i] == num1){
               
            }
            else if(tops[i] == num1){
                count2++;
            }
            else{
                count2 = Integer.MAX_VALUE; // when we cannot swap
            }
        }
        }


        // Case 3 : Replace the top with num2
        for(int i = 0;i<tops.length;i++){
        if(count3 != Integer.MAX_VALUE){// when we cannot swap  here no point of traversing again
            
            if(tops[i] == num2){
            }
            else if(bottoms[i] == num2){
                count3++;
            }
            else{
                count3 = Integer.MAX_VALUE; // when we cannot swap
            }
        }
        }

        // Case 4 : Replace the bottom with num2
        for(int i = 0;i<bottoms.length;i++){
        if(count4 != Integer.MAX_VALUE){ // when we cannot swap  here no point of traversing again
            
            if(bottoms[i] == num2){
               
            }
            else if(tops[i] == num2){
                count4++;
            }
            else{
                count4 = Integer.MAX_VALUE; // when we cannot swap
            }
        }
        }
        // finding minimum no of swap count
        int res =  Math.min(Math.min(count1, count2), Math.min(count3, count4));
        if(res == Integer.MAX_VALUE){ // if result is infinity we cannot make the array of same element
            return -1;
        }
        return res;
    }
}