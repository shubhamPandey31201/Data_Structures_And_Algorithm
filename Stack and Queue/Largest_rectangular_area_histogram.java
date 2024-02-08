// Time complexity O(N)
// in this question we need to find the largest Rectangle in histogram in terms of width*height
// we know always the smallest height will determine the area
// so for any ith index we find the next smallest in left and next smallest in right
// points to remember for first element left next smaller will be -1
// and for last elment right next greater will be n(length of array)
// also we store index in stack ans array instead of value to calculate the width
// width is calculated as rs[i]-ls[i]-1;
// caculate area and compare with max area each time 
// return the max area

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftNextSmaller=new int[n];
        Stack<Integer> lst=new Stack<>();
        lst.push(0);
        leftNextSmaller[0]=-1;// for first element boundary is -1
        for(int i=1;i<n;i++){
            while(lst.size()>0 && heights[lst.peek()]>=heights[i]){
                lst.pop();
            }
            if(lst.size()==0){ // when no element is smaller in left
                leftNextSmaller[i]=-1;
            }
            else{
                leftNextSmaller[i]=lst.peek();

            }
            lst.push(i);
        }
        int[] rightNextSmaller=new int[n];
        Stack<Integer> rst=new Stack<>();
        rst.push(n-1);
        rightNextSmaller[n-1]=n;// for last element in right next smaller
        for(int i=n-2;i>=0;i--){
            while(rst.size()>0  && heights[rst.peek()]>=heights[i]){
                rst.pop();
            }
            if(rst.size()==0){
                rightNextSmaller[i]=n; // when no element is greater 
            }
            else{
                rightNextSmaller[i]=rst.peek();
            }
            rst.push(i);
        }
        int maxArea=0;

        for(int i=0;i<n;i++){
            int width=rightNextSmaller[i]-leftNextSmaller[i]-1;// width calculation
            int length=heights[i];
            int area=width*length;
            maxArea=Math.max(maxArea,area);

        }
        return maxArea;
        
        
    }
}