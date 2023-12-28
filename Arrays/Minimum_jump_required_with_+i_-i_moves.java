
//Time complexity is O(root of target )
// question is suppose we have a target x then in how many jumps starting from 0 can we reach to x such that in every step the jump size increases by 1 and either we can move left or right of the current position
// technically to calculate jump we need to go past the target and then 
// find out the difference between the target and current distance
// if the difference is even then exactly same jump is required to reach the target
// if the difference is odd then we take extra jump and find out the difference again
// if again difference is even then current jump is the answer
// if again different is odd then current jump +1 is the answer since next jump will automaticall make it even 
// if d is difference between the target and the actual distance then at d/2 we go to the negative direction i.e left direction


class Solution {
    public int reachNumber(int target) {
        int jump=1; // first jump will be 1
        int sum=0;
        target=Math.abs(target); // for negative target

        while(sum < target){ // when sum exceeds the target we stop 
            sum+=jump;
            jump++;
           
            
        }
        if((target-sum)%2==0){ // when difference is even 
            return jump-1; // jump-1 because jump++ was already done

        }
        else if((target-sum)%2!=0){ // when difference is odd
            sum+=jump; // we take one more jump and then check the condition again
            if((target-sum)%2==0){  // again if difference is even
                return jump; // jump is the answer
            }
            else{
                return jump+1; // if difference is odd then onto next jump it will automatically be even 
            }
            
        }
        return jump+1;
        
    }
}