// User function Template for Java
// Time Complexity is O(n) and space Complexity is O(n*m)
// create an array of size row*column
// sort the array
// then insert the value of array into the matrix back


class Solution {
    int[][] sortedMatrix(int N, int Mat[][]) {
        
        // code here
        int rowLength=Mat.length;
        int columnLength=Mat[0].length;
        int []arr=new int[rowLength*columnLength];
        int k=0;
        // adding the elements into the array
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<columnLength;j++){
                
                arr[k]=Mat[i][j];
                k++;
                
            }
            
        }
        
        Arrays.sort(arr); // sorting array
        k=0;
        // inserting the element of sorted array back into the matrix
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<columnLength;j++){
                Mat[i][j]=arr[k];
                k++;
            }
        }
        return Mat;
    }
};