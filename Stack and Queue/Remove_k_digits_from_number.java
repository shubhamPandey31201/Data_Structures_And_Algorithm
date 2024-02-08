// time complexity is O(N)
// simple intuition is remove the peek() element if it is greater than current element
// while poping decrease k 
// still if k>0 
// pop from stack until k>0
// at last remove the leading zero and convert into the string and return 
class Solution {
    public String removeKdigits(String num, int k) {
        char[] arr=num.toCharArray();
        int n=arr.length;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<n;i++){
            char ch=arr[i];
            while(st.size()> 0 && k>0 && st.peek()>ch) { // remove if previous is greater than current
                st.pop();
                k--;
            }
            st.push(ch); // push current ch
        }
        while(k>0){ // even after poping if k>0 pop till k==0
            st.pop();
            k--;
        }
        char [] ans=new char[st.size()];
        for(int i=ans.length-1;i>=0;i--){// adding to array
            ans[i]=st.pop();
        }
        int i=0;
        while(i<ans.length && ans[i]=='0'  ){ // removing leading zero
            i++;
        }
        StringBuilder sb=new StringBuilder(); // converting into string
        while(i<ans.length){
            sb.append(ans[i]);
            i++;


        }
        if(sb.length()==0) return "0"; // if string length is 0 return 0
        return sb.toString();
        
    }
}