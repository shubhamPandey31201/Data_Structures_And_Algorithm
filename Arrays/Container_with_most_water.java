//time complexity is O(n)
// we need to find the maximum area with the given height in the form of array
// smallest height determines the area not the longest height
// so we keep ith pointer to the first index and jth pointer to the last index
// we calculate area is minimumHeight * difference in index of heights
// ansArea is upated when current area is maximum than the previous maximum area
// so if ith height is smallest then increase ith pointer or if jth height is smallest than decrease jth pointer since longer height doesn't have effect in the area
class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maximumArea=Integer.MIN_VALUE;
        
        while(i<j){
            int area=Math.min(height[i],height[j])*(j-i); // area calculation
            maximumArea=Math.max(area,maximumArea);// updating ans if currentarea is maximum
            if(height[i]<height[j]){ // if ith height is smaller increase ith pointer
            
                i++;
            }
            else{ // if jth height is smaller decrease jth pointer
                j--;
            }
        
        }
        return maximumArea;


        
    }
}