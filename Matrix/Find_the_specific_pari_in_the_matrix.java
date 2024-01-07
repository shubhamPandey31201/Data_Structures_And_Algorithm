// time complexity is O(n^2);
// imp condition to notice is c>a and d>b where a,b,c,d are index of the matrix
//to solve this question will create a maxMatrix whole first element will contain the maximum of the array
// similarly all sub-matrix first element will contain the maximum all elements
//to make maxMatrix we start from last element
// will fill last row first then last column with max element 
// then onwards will fill other cell
// so according to condition of the question for element at mat[i][j] we need to find maxElement between the array whose index are greater or equal to i+1 or j+1
// this means we need to find the max element in the sub-matrix 
// we already calculated maxMatrix so for mat[i][j] max element in the sub-matrix will be at maxElement[i+1][j+1]
// so we calculate the difference of min and max element for each element
// whichever diff is maximum will be the answer

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int findMaxValue(int mat[][], int n) {
       int[][] maxMat=new int[n][n];
       maxMat[n-1][n-1]=mat[n-1][n-1];// adding last element in the maxMatrix
       for(int i=n-2;i>=0;i--){ // filling last row
           maxMat[n-1][i]=Math.max(mat[n-1][i],maxMat[n-1][i+1]); // compares with RHS element

       }
       for(int i=n-2;i>=0;i--){// filling last column
           maxMat[i][n-1]=Math.max(mat[i][n-1],maxMat[i+1][n-1]);// compares with below element
       }
       for(int i=n-2;i>=0;i--){// filling remaining cells
           for(int j=n-2;j>=0;j--){
               maxMat[i][j]=Math.max(Math.max(maxMat[i+1][j],maxMat[i][j+1]),mat[i][j]); // compares with below and RHS element
           }
       }

       int ans=Integer.MIN_VALUE;
       for(int i=0;i<n-1;i++){ // n-1 to handle out of bound exception 
           for(int j=0;j<n-1;j++){
               // current element will be mininum
               int min=mat[i][j];
               // element to i+1 and j+1 of matMatrix will be max in remaining sub-matrix
               int max=maxMat[i+1][j+1]; 
               ans=Math.max(ans,max-min);

           }
       }
       return ans;
    }
}
