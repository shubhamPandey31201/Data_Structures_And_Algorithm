// time complexity is O(n)
// here question simply ask how many times does the bulb glow blue
// bulb glow blue when all the previous blub is glown than the current bulb
// so we calculate the left max and check if left max is equal to the current bulb or not i.e i+1;

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int n=flips.length;
        int leftMax[]=new int[n];
        int prevMax=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<n;i++){
            
            leftMax[i]=Math.max(prevMax,flips[i]);
            prevMax=leftMax[i]; // calculating left max

        }
        for(int i=0;i<n;i++){
            if(leftMax[i]==i+1){ // checking if leftMax==current bulb no i.e i+1
                count++; // if yes that mean bulb glows blue
            }
        }
        return count;
        
    }
}