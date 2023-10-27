//  to be a rotaion of a string also the original string length
// and rotated string length should be same 
// concatenate original string with itself and check if it contains rotated string ort not
class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String rotateString=s+s;
        if(rotateString.contains(goal)){
            return true;
        }
        return false;
        
    }
}