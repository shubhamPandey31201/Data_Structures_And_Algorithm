// time complexity is O(N)
// it is the extension of next greater element question
// the only change here is the array given as input is circular
// so to solve this question 
// we perform pop and push operations for second last to first element of the input array
// when top of stack is smaller we pop 
// every time we push current element
// after stack is updated 
// we perform pop add and push task from last element of the array 
// for each ith element we look for the greater element by pop all the element which is smaller than ith element
// after pop all smaller element. there will be two cases 
// i.e either the stack is empty or top has greater element
// so if stack is empty result[i] will have -1 value which means there is no element greater on right hand side
// else add the top element of the stack to the ith index
// after every add opertion push the ith element to the stack 
// and return the result array
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<>();
        if(n>1) st.push(nums[n-2]);// push second last element into the stack
        for(int i=n-3;i>=0;i--){// performing pop and push operations

            while(st.size()>0 && st.peek()<=nums[i]){
                st.pop();

            }
            st.push(nums[i]);
        }
        for(int i=n-1;i>=0;i--){// traversing from last element to the first element
            while(st.size()>0 && st.peek()<=nums[i]){// pop until top of stack is greater than current element
                st.pop();
            }
            if(st.size()==0){// add -1 to the current index if stack is empty since there is no greater element  on right side than the current element
                res[i]=-1;
            }
            else{
                res[i]=st.peek();// add the top of stack since it is the next  greater
            }
            st.push(nums[i]);// push current element to the stack
        }
        return res;

        
    }
}