// time complexity is O(n)
// question is to find the lowest positive integer which is not present in the array exculding 0
// first we will check if 1 is present or not in array and along side with make 1 whenever we find num[i]<=0 and n[i]>n cause below 0 and above n can't be the answer
// second we need to make negative to the value of index that was the value of current interation
// so again after traversing from start whichever index value is positive that value is the least positive integer not present in the array
class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean onePresence=false; // for checking if 1 is present in the array or not
        int n=nums.length;

        for(int i=0;i<n;i++){
            if(nums[i]==1){
                onePresence=true;
            }
            if(nums[i]<=0 || nums[i]>n){ // making all the element below =0 and above n 1 since they don't take part in the answer
                nums[i]=1; 
            }

        }
        if(onePresence==false){//if there doesn't  exit 1 in the array return 1
            return 1;
        }
        for(int i=0;i<n;i++){
            int indexToBeMadeNegative=Math.abs(nums[i])-1;// for current value make negative to the index -1 value
            nums[indexToBeMadeNegative]=-(Math.abs(nums[indexToBeMadeNegative])); 
        }
        int j=0;
        while(j<n){
            if(nums[j]>0){ // if index has postive value then index+1 will be the answer since at index-1 corresponds the value
                return j+1;
            }
            j++;
        }
        return n+1; // then all are negative that means n+1 will be the answer
        
        
    }
}