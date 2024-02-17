// Time complexity is O(n)
// intuition is push the element and check if it matches to the current Pointer element to the another array
// if it matches pop it out check compare for next element
// if the pointer let's  say j is equal to the length of the array then return true else return false


class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Stack<Integer> st=new Stack<>();
        int j=0;// pointer to popped array
        for(int e:pushed){
            st.push(e);// push element to the stack
            while(st.size()>0 && st.peek()==popped[j]){ // if stack peek() == jth index element popping it out
                st.pop();
                j++;
            }
        }
        if(j==popped.length) return true; // this concludes stack valid stack
        return false;
        
    }
}