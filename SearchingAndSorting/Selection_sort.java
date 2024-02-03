// time complexity is O(N^2)
//here there will be n-1 passes 
// in everyPass we assume ith index value is the minIndex
// and we update the value minIdx whenever we get the new minIndex
// and after iterating over entire array we swap 
// that mean n-1 number of swap is required to sort the array

class Solution
{
	int  select(int arr[], int i)
	{
	    return 0;
        // code here such that selectionSort() sorts arr[]
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i=0;i<n-1;i++){
	        int minIdx=i;//initial minIdx
	        for(int j=i+1;j<n;j++){
	            if(arr[j]<arr[minIdx]){
	                minIdx=j;// updating minIdx
	            }
	        }
	        //swapping
	        int temp=arr[minIdx];
	        arr[minIdx]=arr[i];
	        arr[i]=temp;
	    }
	    //code here
	}
}