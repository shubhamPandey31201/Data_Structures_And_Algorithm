// time complexity is O(N);
// space complexity is O(N);
// two optimal approaches are there
// we have been given an array and a target
// we need to find the two element whose addition gives the target
// first approach is using hashmap
// in this approach with the current element we find the corresponding element in the hashmap if it exist we return the answer if it doesnot exist we put the current element in the hashmap which can be used for later elements
// second approach is binary search 
// we sort the array 
// the use two pointer and add first and last element if sum is greater than target decrement the last pointer and vice versa

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> elementIndex= new HashMap<>(); // to store element with its index
        int[] result=new int[2];
        for(int i=0;i<nums.length;i++){
            int val=nums[i]; // current value
            int required=target-val; // value required to achieve the target
            if(elementIndex.containsKey(required)){ // checking if the required element exists in the hashmap
                result[0]=i;
                result[1]=elementIndex.get(required);
                return result;
                
            }
            elementIndex.put(val,i); // if it does not exist put the current element in the hashmap
        }
        return result;
        
    }
}