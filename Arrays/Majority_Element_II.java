
//Same approach as Majority Element (refer that)
// we need to find list of val that has more than n/3 occurence in the array
// since it is n/3 there will only exist 2 element in the list that can meet this condition
// so for two elements we find the highest occurence then check the condition
// time complexity O(n)
class Solution {
    static boolean isGreater(int val,int nums[]){
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(val==nums[i]){
                count++;
            }
        }
        if(count>nums.length/3){
            return true;
        }
        return false;
    }
    public List<Integer> majorityElement(int[] nums) {
        
        int val1=nums[0];
        int val2=nums[0];
        int count1=1;
        int count2=0; // since both val is one only
        for(int i=1;i<nums.length;i++){
            if(nums[i]==val1){
                count1++;
                
            }
            else if(nums[i]==val2){
                count2++;
                
            }
            else{
                if(count1==0){
                    val1=nums[i];
                    count1=1;
                }
                else if(count2==0){
                    val2=nums[i];
                    count2=1;
                }
                else{ // when both count are non - zero
                    count1--;
                    count2--;
                }
            }

        }
        
        List<Integer> res=new ArrayList<>();
        if(isGreater(val1,nums)==true){
            res.add(val1);
        }
        if(isGreater(val2,nums)==true && val1!=val2){ // val1 and val2 should 
                                                        // not be same
            res.add(val2);
        }
        return res;


    }
}

//this solution is also correct


// HashMap<Integer,Integer> frequency=new HashMap<>();
//         int n = nums.length;
//         for(int i=0;i<nums.length;i++){
//             if(frequency.containsKey(nums[i])==true){
//                 frequency.put(nums[i],frequency.get(nums[i])+1);
//             }
//             else{
//                 frequency.put(nums[i],1);
//             }
//         }
//         List<Integer> ans=new ArrayList<>();
//         for(int e:frequency.keySet()){
//             if(frequency.get(e)>n/3){
//                 ans.add(e);
                
//             }
//         }
//         return ans;
        