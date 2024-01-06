// time complexity is O(n)
// an original and a faulty string is given 
// faulty string is formed when some elements in the original strings is pressed long
// we need to find out whether fautly string can be formed from the original string or not when pressed long
// first case if already faulty string length is less than original than ans is false
// will point i pointer to original string and j pointer to faulty string
// and check if ith character is equal to jth character or not 
// if yes then increase both the pointer 
// else if if jth character is equal to i-1th character or not
// if yes just increase jth pointer
// else return false;
// after the end of loop 
// still there maybe two cases 
// where either i still < string length or j is still less then string length
// if ith is less than  string length that mean faulty string is exhausted so ans is false
// if j is less than string length then we check for jth character and i-1th character if not same return false
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i=0;
        int j=0;
        if(typed.length()<name.length()){ // faulty string should always be greater than original string
            return false;
        }
        
        while(i<name.length() && j<typed.length()){
            if(typed.charAt(j)==name.charAt(i) ){ // when equal increase both pointer
                i++;
                j++;
            }
            else if(i>0 &&  typed.charAt(j)==name.charAt(i-1)){ // when equal to previous pointer increase the pointer of faulty string
                j++;
            }
            else {
                return false;
            }
            

            
        }
        
        while(j<typed.length()){ // when faulty string is not yet exhauted check for other character also 
            if(typed.charAt(j)!=name.charAt(i-1)){
                return false;
            }
            j++;
        }
        if(i<name.length()){ // when faulty string is exhausted before original string 
            return false;
        }
        return true;
        
    }
}