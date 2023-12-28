// time complexity O(n)
// question basically ask that with consecutive number addition in who many way can you get the number n
// here k is number of consecutive numbers 
// first we find the highest value of k i.e 2*n > k*(k-1)
// we run loop and find for every k value is the solution valid 
// validation is possible if numerator % k == 0
// where numerator is equal to n- ()k*(k-1)/2)
// if it is valid increment the count
class Solution {
    public int consecutiveNumbersSum(int n) {

        int count=0;
        for(int k=1;2*n> k*(k-1);k++){//run the loop till the highest limitof k 
            int numerator = n- (k*(k-1)/2); // calulating numerator
            if(numerator%k==0){ // checking if possible for value of k or not
                count++;
            }
            
        }
        return count;
        
    }
}
// x = (n-(k*(k-1)/2))/k
// x+ x+1 + x+2 + x+3 +.... + x+k-1 =n
// kx + 0+1+2+..+k-1 = n
// kx + k(k-1)/2 = n
// x= (n -  k(k-1)/2)/k
// since x>0
// (n -  k(k-1)/2)/k > 0
// n= k(k-1)/2
// 2*n = k(k-1) 
// above is the derivation of the solutionss