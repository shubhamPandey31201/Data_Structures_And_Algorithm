class Solution
{
    // Time complexity O(N)
// in this question we need to find the maximum difference between the left next smallest and right next smallest in the aray

// so for any ith index we find the next smallest in left and next smallest in right
// points to remember for first element left next smaller will be 0
// and for last elment right next greater will be 0
// also we store value in stack ans array instead of index to calculate the difference
// width is calculated as rs[i]-ls[i]-1;
// caculate difference and compare with max difference each time 
// return the max difference
    int findMaxDiff(int a[], int n)
    {
        int[] ls=new int[n];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){ // calculating left smaller
            while(st.size()>0 && st.peek()>=a[i]){
                st.pop();
            }
            if(st.size()==0){
                ls[i]=0;
            }
            else{
                ls[i]=st.peek();
            }
            st.push(a[i]);
        }
        int[] rs=new int[n];
        st=new Stack<>();
        st.push(a[n-1]);
        rs[n-1]=0;
        for(int i=n-2;i>=0;i--){ // calculating right smaller
            while(st.size()>0 && st.peek()>=a[i]){
                st.pop();
            }
            if(st.size()==0){
                rs[i]=0;
            }
            else{
                rs[i]=st.peek();
            }
            st.push(a[i]);
        }
        
        int maxDiff=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int diff=Math.abs(rs[i]-ls[i]); // finding differnce
            maxDiff=Math.max(maxDiff,diff);
        }
        return maxDiff;
        
	// Your code here	
    }
}