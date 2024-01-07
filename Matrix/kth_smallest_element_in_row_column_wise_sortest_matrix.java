//time Complexity will be O(maxElement*n*logn)
//first find the smallest and greatest element in the array.first and last element will be smallest and greatest element respectively
//apply binary search between smalest and greatest element 
// for calculate midVal find the number of elements smaller than midVal
// for calcualting number apply binary search in each row where low will be 0th index of the array and n-1th index will be high 
//after every row add low to the count
// now after counting check if count < k or not 
// if not move high to mid-1
// else move low to mid+1



class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
	    
        int lowVal=mat[0][0];// first element
	    int highVal=mat[n-1][n-1];// last element
	    
        while(lowVal<=highVal){
            int midVal=lowVal+(highVal-lowVal)/2;
            int ans=0;// to store count of element that is <= midVal
            for(int i=0;i<n;i++){ // for each row apply binary search where target will be midVal
                int low=0;
                int high=n-1;
                
                while(low<=high){
                    int mid=low+(high-low)/2; 
                    if(mat[i][mid]<=midVal){
                        low=mid+1;
                        
                    }
                    else{
                        high=mid-1;
                    }
                }
                ans+=low;// mid+1 = low i.e mid+1 will be the count
                
            }
            if(ans<k){
                lowVal=midVal+1;
            }
            else{
                highVal=midVal-1;
            }
        }
        return lowVal;
    }
}