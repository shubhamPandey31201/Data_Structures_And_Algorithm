//User function Template for Java

//Time complexity is O(N)
// we find the boundary of non valid paranthese and difference of those index will give the length of valid subString
// steps are first we push -1 to the stack 
// -1 is pushed because if first parentheses is valid -1 will act as invalid ones
// so now whenever ( is is encountered it's index is pushed into the stack
// else when ) is encountered we pop from stack and check if after poping stack is empty or not 
// if its empty we push that index as well and find the difference of current and peek index
// the max of those difference will be the answer
class Solution{
    static int maxLength(String S){
        Stack<Integer> st=new Stack<>();
        st.push(-1);// if first parentheses is valid it will act as invalid index
        int max=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='('){ // whenever open parentheses is encountered push it into the stack
                st.push(i);
            }
            else{
                st.pop(); // else pop 
                if(st.size()==0){// check after poping if empty or not if yes push the current index into stack // this mean the current parentheses is invalid one that is why it is pushed
                    st.push(i);
                }
                max=Math.max(max,i-st.peek()); // peek contains most recent invalid string so everytime we find max as difference between current and peek of stack
            }
        }
        return max; 
        
        // code here
    }
}