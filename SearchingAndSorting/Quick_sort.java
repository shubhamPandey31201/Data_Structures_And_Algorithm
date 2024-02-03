//Time complexity is O(nlogn)
// In quick sort algorithm we take a pivot element here in this question we have taken last element as pivot element
// and all the element smaller than pivot element will be in LHS and all the greater element than pivot element will be in RHS
// simply we do partitioning of the array based on pivot element 
// while partitioning the array is divided into three areas
// from 0 to j-1 --> elements smaller than pivot 
// from j to i-1 --> element greater than pivot
// from i to length-1 --> unknown elements 
// so to solve this question first we find the pivot index and partition arount pivot element
// the Partition algorithm will be
// take pivot element as last element
// keep i and j pointer at first element
// move i pointer and check if element at ith element is greater than pivot element or not
// if yes then increase i by 1
// if not that mean ith element is smaller or equal to pivot element
// so you swap the ith and jth element and increase both i and j index by one
// here after swapping at jth index it contain element smaller than pivot so we increase jth index so that 0 to j-1 contains smaller element
// while at ith index also it contain element greater than pivot element to we increase ith index by as as well
// we reach the end of loop when i is equal to the length of the array
// after successfull paritioning the pivot element is guarenteed to be at its perfect place in sorted context
//since we are considering pivot as last element we swap that element in last with jth index
// and after swapping we increment jth index 
// that is why we return j-1 as pivot index 
// except the pivot element we again partition the array recursive into to halves
// 
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low>high){ // base condition when no elements or single elements are there
            return;
        }
        
        int pivotIndex=partition(arr,low,high); // finding pivot index
        quickSort(arr,low,pivotIndex-1); // partitioning the first half of the array (except pivot element since it is at its perfect position after partition)
        quickSort(arr,pivotIndex+1,high);// partitioning second half
        // code here
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot=arr[high];//consider pivot element as last element
        int i=0;
        int j=0;
        while(i<=high){// when there is no element to explore
            if(arr[i]>pivot){// defining area for greater elements i.e from jth to i-1
                i++;
            }
            else{// defining area for smaller elements i.e from 0th to j-1
                swap(arr,i,j);
                i++;//looking for new element
                j++;//defining area for smaller elements
            }
        }
        return j-1;// since the element equal to pivot element will be at j-1th index and pivot element is always in its sorted location
        // your code here
    }
    static void swap(int [] arr,int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
