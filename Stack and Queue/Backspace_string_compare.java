// Time complexity is O(n)
// we # is encountered pop the element from the stack else push it
// Do the above step for both the string
// at compare both the stack value 
// if equal return true else return false
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        // pushing elements of string first to the stack when # is not encountered else popping 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == '#' && st.size() > 0) {
                st.pop();
            }
        }
        // transferring the element of stack to the array
        char ch[] = new char[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ch[i] = st.pop();

        }
        // again pushing the element of string two to the stack when # is not encounterd else popping
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                st.push(t.charAt(i));

            } else if (t.charAt(i) == '#' && st.size() > 0) {
                st.pop();
            }
        }
        // when length of both string after processing is same then they are not equal
        if (ch.length != st.size()) {
            return false;
        }
        // comparing element by element and return false if any of the elements are not equal
        for (int i = ch.length - 1; i >= 0; i--) {
            if (ch[i] != st.pop()) {
                return false;
            }
        }
        return true;

    }
}