//User function Template for Java
// time complexity is O(n*logc)
//for every row will apply binary search to find the first index of 1
// once we get first index of the 1 we calculate number of 1's
// we compare the number of 1's with all other row 
// if we find max number of 1's from previous count then we update count and index 
// at last we return the index
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        
        // code here
        int ans=Integer.MIN_VALUE;
        int indexAns=-1;
        
        for(int i=0;i<n;i++){
            // for every row 
            int low=0;// first column index
            int high=m-1;// last column index
            int firstIndex=m;// first 1's index
            while(low<=high){
                int mid=(low+high)/2;
                if(arr[i][mid]==1){ // if 1 is there we look for other 1's on lHS
                    
                    high=mid-1;
                    firstIndex=mid;
                }
                else{
                    low=mid+1;// when its 0 
                }
            }
            if(m-firstIndex>ans){ // m is column length so m-firstIndex give number of 1's
                ans=m-firstIndex;
                indexAns=i;
                
            }
        }
        
        return (ans==0)? -1:indexAns;
       
    }
}