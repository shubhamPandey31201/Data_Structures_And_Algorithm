// time complexity O(n)
// Chaining techique
// chaining techique is applied when value and index are related 
// always minium chunks will be 1

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxIdx=-1;// impact 

        int chunkCount=0;

        for(int i=0;i<arr.length;i++){
            maxIdx=Math.max(maxIdx,arr[i]); // maximum impact
            if(maxIdx==i){ // point of chunk division
                chunkCount++;
            }
        }
        return chunkCount;
        
    }
}