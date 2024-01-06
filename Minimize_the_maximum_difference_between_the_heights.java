// User function Template for Java
// time complexity is O(nlogn)
// vvvvvvvi question
// first sort the array
// then we can say the difference between the height of maximum and minimum will be the maximum difference
// if we add K to maximum element that will increase the diff and sub the minimum element with k that too will increase the diff
// that mean to minimize the height we should increase smallest element and decrease greatest element
// also the claim is two consecutive element will have min diff so somehow if we add  K and sub  K to two consecutive elements that makes them smallest and largest element in the array 
// then maybe their sum can be the minimum 

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);//sorting
        // code here
        int max=arr[n-1];
        int min=arr[0];
        int diff=max-min;// max difference till now
        for(int i=1;i<n;i++){
            if(arr[i]>=k){// since left arr[i]<k then negative number will come after subtracting
                max=Math.max(arr[i-1]+k,arr[n-1]-k); // comparing with largest element - k
                min=Math.min(arr[i]-k,arr[0]+k); // comparing with smallest element + k 
                
            }
            diff=Math.min(diff,max-min); // checking for min every time
        }
        return diff;
    }
}
