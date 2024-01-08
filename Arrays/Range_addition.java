// time complexity is O(N)
// we have been given 2d array
// each row of 2d has three elements value of 0th index represents starting index value of 1th index represent last index and value of 2th index value to be incremented
// we need to increment the value in a array of length l whose initial values are 0
// we need to apply these query on the array and return 
// we solve this question in an optimised way 
// first we look for retrieve first and last index and retrive the value
// we add value to first element and subtract value in last+1th index to nullify the effect in prefix array
// after apply above step for all query 
// calculate the prefix sum array and return
public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int row=updates.length;
        int []ans=new int[length];
        // applying the query by adding value at first index and subtracting value in last+1 index
        for(int i=0;i<row;i++){
            int startIdx=updates[i][0];
            int endIdx=updates[i][1];
            int value=updates[i][2];
            ans[startIdx]+=value;
            if(endIdx+1<length){ // in case lastindex is length-1 we skip subracting value 
                
                ans[endIdx+1]-=value;


            }

        }
        // calculating prefix sum array
        for(int i=1;i<length;i++){
            ans[i]=ans[i]+ans[i-1];
        }
        return ans;



    }
}