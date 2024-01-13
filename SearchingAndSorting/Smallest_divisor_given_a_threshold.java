// same as koko eating bananas
// //Time complexity is O(nlogn)
// this question is based upon rate 
//here piles.length <= threshold <=10^9
// therefore low=1 and high = max of array
// apply binary search between low and high 
// for each mid value find temp threshold and check if temp threshold <= threshold
// if temp theshold<= threshold && tempThreshold >0 high=mid-1 
// else temp threshold < threshold && tempThreshold<0 low=mid+1
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        // finding max
        for(int e:nums){
            max=Math.max(e,max);

        }
        if(threshold==nums.length) return max;
        int low=1;
        int high=max;
        int ans=Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;
            int tempThreshold=0;
            
            for(int e:nums){
                // caculating ceil value and adding it to  tempThreshold 
                // ceil value if calculated by integer division and incrementing it with 1 if there is decimal after integer division 
                tempThreshold+=e/mid;
                if(e%mid != 0){
                    tempThreshold++;
                }

            }
            if(tempThreshold<=threshold && threshold>0){
                ans=mid;
                // to increase tempThreshold

                high=mid-1;
                
            }
            else if(tempThreshold>threshold || threshold<0){
                // to decrease tempthreshold
                low=mid+1;
            }
            
        }
        return ans;
        
    }
}