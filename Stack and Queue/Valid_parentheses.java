// Time complexity O(N)
// whenever open bracket is encountered push it into the stack
// and whenever close bracket is encountered check following condition
// first see if stack size ==0 if yes return false
// if top of stack is not equal to same type of open bracket then return false
// else pop // that mean top of stack has same type of open bracket
class Solution {
    public boolean isOpen(char ch){ // checking if the character is open bracket or not
        if(ch=='(' || ch=='{' || ch=='['){
            return true;
        }
        return false;
    }
    public boolean matched(char st,char ch){ // check if top of stack is open bracket match for the close bracket match or not 
        if(ch==')' && st=='('){
            return true;
        }
        else if(ch=='}' && st=='{'){
            return true;
        }
        else if(ch==']' && st=='['){
            return true;
        }
        return false;
    }

    public boolean isValid(String s) {
        char[] arr=s.toCharArray();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<arr.length;i++){ 
            
            if(isOpen(arr[i])){ // whenever open bracket is encountered push it into the stack
                st.push(arr[i]);
            }
            else{
                if(st.size()==0){ // if first element itself or when there is no prior open bracket that and close bracket is ecountered that means it is invalid
                    return false;
                }
                if(st.size()>0 && !matched(st.peek(),arr[i])){ // if top of stack is not matched open bracket then invalid
                    return false;
                }
                else if(st.size()>0 && matched(st.peek(),arr[i])){ // when matched open bracket is found return pop top 
                    st.pop();
                }
            }
            
            
        
                
            
            
        }
        if(st.size()>0) return false; // if size > 0 that means invalid
        return true;
        
    }
}