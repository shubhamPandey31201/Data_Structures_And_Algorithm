// Time complexity is O(n)
// here we need three things first is a stack second is frequency array and third is exist array
// stack contains the pushed elements
// frequency array contains frequency of characters when a character is encountered it's freqeuncy is decreased
// exists array is a boolean array that stores true if a character is there in stack and false if the character is not in stack
// first fill the frequency array with the frequency of each character 
// for mapping character to array we use subtract character with -'a'. It works on ascii value
// we run loop and fetch each element and decrease its frequency and check if that element already exist in stack or not by cross verifying it with exist array
// if it exists we continue 
// else we check if stack peek()> current Character if yes we pop element out and make false for that element in exist array
// and last we push in the array and  we make true for current character in exist array

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int freq[] = new int[26];
        boolean exists[] = new boolean[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {// initialising frequency array
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        for (int i = 0; i < n; i++) { 
            char ch = s.charAt(i);
            freq[ch - 'a']--;// decrementing frequency for ch
            if (exists[ch - 'a'])// if ch already exsisted in stack no need to do anything
                continue;
            while (st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0) { // when stack peek()> ch then it is popped out 

                exists[st.peek() - 'a'] = false; // exist array should be false for popped element

                st.pop();

            }
            st.push(ch);// push current element
            exists[ch - 'a'] = true;// make true for ch in exist array
        }
        // converting into string
        char[] ans = new char[st.size()];
        StringBuilder sb = new StringBuilder();

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();

        }
        for (char e : ans) {
            sb.append(e);
        }
        return sb.toString();

    }
}