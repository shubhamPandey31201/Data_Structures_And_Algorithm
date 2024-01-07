//Time complexity is (log n*m)
//here the matrix is sorted 
// so we can apply binary search 
// we have to assume each cell as index of an array 
// so for binary search low=0 and high=totalElement-1 , which is considered as last index of the array
// here with array index we can get matrix index also 
// array index/column length give row index of matrix
// while array index%column length gives column index of matrix
// so whenever matrix[mid/columnLength][mid%columnLength]==target
// we return true else follow binary search rules futher on
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength=matrix.length;
        int columnLength=matrix[0].length;
        int low=0;
        int high=(rowLength*columnLength)-1;
        while(low<=high){
            int mid =(low+high)/2;
            if(matrix[mid/columnLength][mid%columnLength]==target){ // when mid element is equal to target
                return true;
            }
            else if(matrix[mid/columnLength][mid%columnLength]>target){ // when mid element is greater than target
                high=mid-1;
            }
            else{ // when mid element is lesser than the target
                low=mid+1;
            }
        }
        return false;


        
        
    }
}

        // int i=0;
        // int j=matrix[0].length-1;
        

        // while(j>=0 && j<matrix[0].length && i>=0 && i<matrix.length){
        //     int currentElement=matrix[i][j];
        //     if(target==currentElement){
        //         return true;
        //     }
        //     else if(currentElement<target){
        //         i++;
        //     }
        //     else if(currentElement>target){
        //         j--;
        //     }

        // }
        // return false;