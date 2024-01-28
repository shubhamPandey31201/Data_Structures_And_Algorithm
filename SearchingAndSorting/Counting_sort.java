// time complexity is O(N)
//sorting color problem is basically a count sort problem
// count sort algorithm is a sorting algorithm 
// we use count sort algorithm when there are element repeated multiple times and the range of element is small for example in this question range is from 0 to 2
// first we make a frequency array which contains the frequency of the element 
// and element is mapped to the index of the array
// then we calculate prefix sum array of frequency array 
// prefix sum array makes sure the last position of the element in the array
// then we start traversing element from backward in the original array 
// and put that element into its sorted position by taking reference of prefix sum of frequency array
// we use this method to maintain the stability of the position of the element of the array since count sort is the stable sort algorithm
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        // we need to find the min and max of the array to max it with the index of the frequency array
        int min=0; 
        int max=2;
        int [] freqArr=new int[max-min+1]; // size of frequency array will be max-min+1
        for(int i=0;i<n;i++){ // traversing the original array
            int val=nums[i];
            int idx=val-min;// mapped index 
            freqArr[idx]++; // increasing the frequency for the val
        }
        for(int i=1;i<freqArr.length;i++){ // calculating the prefix sum frequency array
            freqArr[i]=freqArr[i]+freqArr[i-1];
        }

        int []ans=new int[n];
        for(int i=n-1;i>=0;i--){ // traversing backwards
            int val=nums[i]; // value to be added 
            int position=freqArr[val-min]; // last position of the val
            int idx=position-1; // actual index since position is one greater in index terms
            ans[idx]=val;// adding val to sorted index in the array
            
            freqArr[val-min]--; // decreasing the frequency 
        }
        for(int i=0;i<n;i++){ // transfering the sorted array to original array
            nums[i]=ans[i];
        }
        
    }
}