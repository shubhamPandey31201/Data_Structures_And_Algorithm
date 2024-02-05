// time complexity is O(N)
// here for every ith index we store the just next greater element to ith value in the ith index
// we use stack and perform pop add and push operation
// steps to follow are
// first we push the last element to the stack
// and in result array we keep -1 to last index since there is no greater element on the right side
// then from second last element we run the loop till first element 
// for each ith element we look for the greater element by pop all the element which is smaller than ith element
// after pop all smaller element. there will be two cases 
// i.e either the stack is empty or top has greater element
// so if stack is empty result[i] will have -1 value which means there is no element greater on right hand side
// else add the top element of the stack to the ith index
// after every add opertion push the ith element to the stack 
// and return the result array

class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st=new Stack<>();
        st.push(arr[n-1]);// pushing last element to the array
        long[] res=new long[n];
        res[n-1]=-1;// add -1 to the last index of the array since there is no greater element on right side
        
        for(int k=n-2;k>=0;k--){ // traversing from second last element to the first element
            while(st.size()>0 && st.peek()<=arr[k]){ // pop until top of stack is greater than current element
                st.pop();
            }
            if(st.size()==0){// add -1 to the current index if stack is empty since there is no greater element  on right side than the current element
                res[k]=-1;
                
            }
            else{
                res[k]=st.peek(); // add the top of stack since it is the next  greater
                
                
            }
            st.push(arr[k]); // push current element to the stack
            
            
            
        }
        return res;
        // Your code here
    } 
}