//Time complexity is O(N)
// here the intuition is the remove all the balanced parentheses and return the size of stack remained at last
class Solution {
    public int minAddToMakeValid(String s) {
        int n=s.length();
        char[] arr=s.toCharArray();
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=arr[i];
            if(ch=='('){ // for open parentheses push
                st.push(ch);
            }
            else{
                if(st.size()==0){ // when size is 0 push
                    st.push(ch);
                }
                else if(st.peek()=='('){ // when balanced with open pop
                    st.pop();
                }
                else{ // when st.peek()==')'
                    st.push(ch);
                }

            }
        }
        return st.size(); // stack contains unbalanced parantheses at last 
        
    }
}