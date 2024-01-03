//Time complexity is O(nlogn) for sorting
// we need to return the sum of width of the all possible subsequence of the array where width is the difference between the smallest and largest number of the array
// for a given n size of array the total number of subsequence will be 2^n
// since this question is not concerned with the sequence of the subsequence but rather wants the smallest and greatest element of the subsequence 
// first we sort the array
// now for every element we calculate who many time it comes at the last and first of the subsequence
// if a number comes at the first of the subsequence it means it is the smallest and if it comes at last then it is greatest number in the subsequence
// so we calculate the number of subsequence that end and starts with the element
// then our answer will be as numberOfSubsequenceThatEndswith*num1-numberOfSubsequenceThatStartsith*num1+numberOfSubsequenceThatEndswith*num2-numberOfSubsequenceThatStartsWith*num2 and soon



class Solution {
    public int sumSubseqWidths(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);// sorting the array
        int mod=1000000007; // to balance overflow
        long[] numsOfSubsequenceOnLeftSide=new long[n];
        //arr[]={2^0,2^1*2^2*2^3*2^4*2^5*2^6*....2^n}
        // for ith element the number of sequence for which it comes at last is 
        // is 2^i
        // for ith element the number of sequence for which it comes at first is
        // is 2^n-i-1
        numsOfSubsequenceOnLeftSide[0]=1;//2^0
        long ans=0;
        for(int i=1;i<n;i++){
            numsOfSubsequenceOnLeftSide[i]=(numsOfSubsequenceOnLeftSide[i-1]*2)%mod;
        }
        for(int i=0;i<n;i++){
            ans=(ans+numsOfSubsequenceOnLeftSide[i]*nums[i]-numsOfSubsequenceOnLeftSide[n-i-1]*nums[i])%mod; // for every element finding width and adding to answer

        }
        return (int)ans;

        
    }
}