import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

// time complexity is O(n*m);
//first transpose the array then reverse the array columnwise 
// transpose is simplying rotation along the diagonal elements
// reversing columnwise because we have to rotate anti-clockwise
public class Solution {
	public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> matrix){

		int row=matrix.size();
		int column=matrix.get(0).size();
		// transposing matrix
		for(int i=0;i<row;i++){
			for(int j=0;j<i;j++){
				int temp=matrix.get(i).get(j);
				matrix.get(i).set(j,matrix.get(j).get(i));
				matrix.get(j).set(i,temp);
				
			}
		}
		// reversing elements column wise
		for(int k=0;k<column;k++){
			int i=0;
			int j=row-1;
			while(i<j){
				int temp=matrix.get(i).get(k);
				matrix.get(i).set(k,matrix.get(j).get(k));
				matrix.get(j).set(k,temp);
				i++;
				j--;
			}
		}
		return matrix;
	}
}