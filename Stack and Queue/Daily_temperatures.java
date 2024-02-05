// time complexity is O(N)
// similar to next greater element 
// but here we need to push index of the element instead of the element itself
// and in add operation we add the length from curr to next greater element
// first we push the last index to the stack
// and in result array we keep 0 to last index since there is no greater element on the right side
// then from second last element we run the loop till first element 
// for each ith element we look for the greater element index by poping all the element index which is smaller than ith element
// after pop all smaller element index. there will be two cases 
// i.e either the stack is empty or top has greater element
// so if stack is empty result[i] will have 0 value which means there is no element index greater on right hand side
// else add the top index of the stack to the ith index
// after every add opertion push the ith index to the stack 
// and return the result array
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        res[n-1]=0; // adding 0 to last index
        st.push(n-1);// push last index to stack
        for(int i=n-2;i>=0;i--){
            while(st.size()>0 && temperatures[st.peek()]<=temperatures[i]){// remove all smaller element indexes from stack
                st.pop();
            }
            if(st.size()==0){// checking if stack is empty
                res[i]=0;// there isn't any index such that its element is greater than current element
            }
            else{
                res[i]=st.peek()-i;// adding the no of day gaps 
            }
            st.push(i);// adding index
            
        }
        return res;
        
    }
}