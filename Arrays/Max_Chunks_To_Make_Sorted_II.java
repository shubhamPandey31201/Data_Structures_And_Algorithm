
// time complexity O(n)
// same chaining techique but for distinct values
// calculate leftMax and rightMin array
// whenever you find leftMax[i]<rightMin[i+1] make a chunk
// leftMax for ith value is the highest from 0th to ith index
// while rightMin for ith value is the minimum from ith to end index 

class Solution {
    public int maxChunksToSorted(int[] arr) {
        /*make rightMin array which contains min element from ith index to end 
        of array*/
        int n=arr.length;
        int rightMin[]=new int[n+1];//arr.length+1 for handeling index 
                                            // out of bound exception
        rightMin[n]=Integer.MAX_VALUE;

        for(int i=n-1;i>0;i--){
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
            

        }
        // no need to make leftMax array since we can iterate leftMax and
        //   compare at same time
        int leftMax=Integer.MIN_VALUE;
        int chunkCount=0;
        for(int i=0;i<n;i++){
            leftMax=Math.max(leftMax,arr[i]);
            
            if(leftMax<=rightMin[i+1]){ // equality because we need to calculate
                                            // maximum chunks
                chunkCount++;
            }
            
            

        }
        return chunkCount;

        
    }
}