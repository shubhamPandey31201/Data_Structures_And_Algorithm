import java.util.* ;
import java.io.*; 
public class Solution {
	    // in wiggle sort the element present in the even index should be smaller than its left and right element 
      // while element present in the odd index should be greater than its right and left index element
      // here we don't check for left element since automatically i will fall in the condition so we only check for the right element
      // if index is even and right index element is smaller than the current index element then swap
      // if index is odd and right index element is greater than the current index element then swap
	public static void swap(int arr[],int i,int j){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static int[] wiggleSort(int n, int[] arr) {
		for(int i=0;i<n-1;i++){
			if(i%2==0 && arr[i]>arr[i+1]){ // for even index checking the condition
				swap(arr,i,i+1);
			}
			if(i%2!=0 && arr[i]<arr[i+1]){ // for odd index checking the condition
				swap(arr,i,i+1);
			}
		}
		return arr;
		// Write your code here.
	}
}