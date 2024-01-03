// time complexity is O(n)
// if we eliminate one char from string then will it be a palindrome or not we need to check that
// for a palindrome string 1st and last element should be same and goes on for next element
// for this condition whenever we find an element that is not equal to its first or last element we skip that and check for the rest of the string 
// if rest of the string gives palindrome then answer will be true else false
class Solution {
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){ // finding the faulty character
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            // if there exist any faulty character
            // faulty character can be at ith index or jth index so checking 
            // checking for both case
            else if(isPalindrome(s,i+1,j)|| isPalindrome(s,i,j-1)){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
        
        
    }
}