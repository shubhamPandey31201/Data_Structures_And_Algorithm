// time complexity O(n)
// since both array is sorted so we merge it in single array
// after merging we find median and return 
// for even number of element in merged array median will be sum of mid two elements/2
// and for odd element mid element will be the median

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n =nums1.length;
        int m=nums2.length;
        int ans[]=new int[n+m];
        int i=0;
        int j=0;
        int k=0;

        // merging nums1 and nums2

        
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                ans[k]=nums1[i];
                
                i++;
            }
            else{
                ans[k]=nums2[j];
                j++;
            }
            k++;


        }
        // for remaning element in nums1
        while(i<n){
            ans[k]=nums1[i];
            k++;
            i++;
        }
        // for remaning element in nums2
        while(j<m){
            ans[k]=nums2[j];
            k++;
            j++;
        }
        int mid=ans.length/2;
        if(ans.length%2==0){ // for even number of element 
            int a=ans[mid];
            int b=ans[mid-1];
            return (a+b)/2.0; // sum of two mid elements by 2
        }
        // ans is required in double so / 1.0
        return ans[mid]/1.0; // for even number of elements
        
    }
}