//time complexity will be O(n^2)
// it just involes two steps 
// first you transpose the entire matrix
// then you reverse the element row-wise
class Solution {
    public void rotate(int[][] matrix) {
        int row=matrix.length;
        int column=matrix[0].length;
        // transposing the matrix

        for(int i=0;i<row;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // reversing the elements row-wise
        int i=0;
        while(i<row){
            int j=0;
            int k=matrix[i].length-1;
            while(j<k){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][k];
                matrix[i][k]=temp;
                j++;
                k--;
            }
            i++;

        }
        
        
    }
}