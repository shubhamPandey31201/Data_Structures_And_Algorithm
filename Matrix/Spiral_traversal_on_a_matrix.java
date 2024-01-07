// Time complexity is O(n*m)
//we run the loop until current number of Element is less than total element
// we traverse box wise 
// first we add upper box where row is constant and min to max column traversal is there
// secondly we add right box where column is constant and min to max row traversal is there
// thirdly we add lower box where row is constant and max to min column traversal is there
// fortly we add left box where column is constant and max to min row traversal is there
// once outer box is completed we go for inner box also edge element are not added two
// since upper box starts with minRow we increase minRow++
// similarly rightBox maxColumn--
// similarly lower box maxRow--;
// similarly leftBox minColumn++;
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow=0; 
        int minColumn=0;
        int maxRow=matrix.length;
        int maxColumn=matrix[0].length;
        List<Integer> ans=new ArrayList<>();
        int currentNoOfElement=0;
        int totalElement=maxRow*maxColumn;
        while(currentNoOfElement<totalElement){
            // upper box
            for(int i=minColumn;i<maxColumn && currentNoOfElement<totalElement;i++){
                ans.add(matrix[minRow][i]);
                currentNoOfElement++;
            }
            minRow++;
            // right box
            for(int i=minRow;i<maxRow  && currentNoOfElement<totalElement;i++){
                ans.add(matrix[i][maxColumn-1]);
                currentNoOfElement++;
            }
            maxColumn--;
            // lower box
            for(int i=maxColumn-1;i>=minColumn && currentNoOfElement<totalElement;i--){
                ans.add(matrix[maxRow-1][i]);
                currentNoOfElement++;
            }
            maxRow--;
            // left box
            for(int i=maxRow-1;i>=minRow && currentNoOfElement<totalElement;i--){
                ans.add(matrix[i][minColumn]);
                currentNoOfElement++;
            }
            minColumn++;
        }
        return ans;
        
        
    }
    
}