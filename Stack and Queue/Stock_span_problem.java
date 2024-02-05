// time complexity is O(n);
// same is daily temperature problem but we find next greater element index from left hand side rather than right hand side


class Solution
{
    //Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[n];
        res[0]=1;// for first element there isn't any element greater in left side so adding 1
        st.push(0);// pushing index into the stack
        for(int i=1;i<n;i++){// traversing from second index to last index
            while(st.size()>0 && price[st.peek()]<=price[i]){// removing index that has smaller element than the current element from the stack
                st.pop();
            }
            if(st.size()==0){ // if size is 0 span will be i-0+1 i.e i+1
                res[i]=i+1;
            }
            else{
                res[i]=i-st.peek();//span when we find top index has greater value
            }
            st.push(i);// pushing current index
        }
        return res;
        
        // Your code here
    }
    
}