//User function Template for Java



//User function Template for Java
// time complexity is O(nlogn)
// we can also achieve this problem in O(n^2) but it is not the optimal way 
// this question ask the number to swaps possible to sort the array
// swap is possible when left element is greater than right element 
// we can count the inversion during mering the array when applying merge sort
// when element in left sorted array is greater than element in right sorted array 
// then we increase the count inversion by left sorted array length- current index of element i.e i
// since all other element in lsa after ith index will also be greater than the element in jth index in right sorted array
// at last we return the count inversions


class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
         long low = 0;
        long high = N-1;
        return inv(arr,low,high); // applying merge sort
        
    }
    public static long inv(long arr[], long low, long high){
        long res = 0;
        if(high>low){// base condition
            long mid = (low+high)/2;
            res +=inv(arr, low, mid);
            res +=inv(arr,mid+1,high);
            res +=countMerge(arr,mid,low,high);// merging array
        }
        return res;
    }
    static long countMerge(long arr[], long mid, long low, long high){
        long n1 = mid - low + 1; // calculating length for lsa
        long n2 = high - mid;// calculating length for rsa
        long res = 0;
        long left[] = new long[(int)n1];
        long right[] = new long[(int)n2];
        for(int i=0;i<n1;i++){
            left[i] = arr[i+(int)low] ; // making lsa
        }
        for(int j=0;j<n2;j++){
            right[j] = arr[(int)mid+1+j]; // making rsa
        }
        int i=0;
        int j=0;
        int k = (int)low;
        while(i<n1 && j<n2){ // merging
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{// inversion happend here when left[i]> right[j]
                arr[k++] = right[j++];
                res = res+(n1 - i); // n1 is the length of lsa 
                // n1-i because for after all element after ith element will ultimaterly be greater than jth element in rsa
                
            }
        }
         while(i<n1 ){// when lsa is not exhausted
            
                arr[k++] = left[i++];
           
        }
        while(j<n2 ){ // when rsa is not exhausted
            
                arr[k++] = right[j++];
           
        }
        return res;
    }
}

//User function Template for Java

