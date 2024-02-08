//User function Template for Java
//Time complexity is O(N)
// question has asked that how many bracket has to be reversed from open to close or close to open to make the bracket balanced
// see first find openBracket count and closeBracket count which are not balanced 
// the addition of ceil of division of openBracket and closeBracket is the answer

class Sol
{
    int countRev (String s)
    {
        if(s.length()%2!=0) return -1;
        char[] arr=s.toCharArray();
        Stack<Character> st=new Stack<>();
        int openCount=0;
        int closeCount=0;
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]=='{'){ // whenever open bracket is there increase the openCount
                openCount++;
            }
            
            else{
                if(openCount==0){ // if open count is 0 and current character is } increase closeCount
                    closeCount++;
                }
                else{
                    openCount--; // else there is open bracket on the top of stack which is balanced by } so openCount --
                }
            }
            
            
        }
        int openReversal=(int)Math.ceil(openCount/2.0);
        
        int closeReversal=(int)Math.ceil(closeCount/2.0);
        
        return openReversal+closeReversal;
        // your code here       
    }
}