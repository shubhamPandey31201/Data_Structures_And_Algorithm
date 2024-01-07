//User function Template for Java
//time Complexity will be O(maxElement*n*logn)
//first find the smallest and greatest element in the array.f
//apply binary search between smalest and greatest element 
// for calculate midVal find the number of elements smaller than midVal
// for median elements elements smaller than mid val should be <= totalElement/2
// for calcualting number apply binary search in each row where low will be 0th index of the array and n-1th index will be high 
//after every row add low to the count
// now after counting check if count <= totalElement/2 or not 
// if not move high to mid-1
// else move low to mid+1

class Solution {
    int median(int matrix[][], int R, int C) {
        
        // code here  
        int lowVal=Integer.MAX_VALUE;
        int highVal=Integer.MIN_VALUE;
        int totalElement=R*C;
        // since is row wise sorted min element will be found at first column
        // and maximum element will be found at last column
        
        for(int i=0;i<R;i++){
            lowVal=Math.min(lowVal,matrix[i][0]);// finding lowest element
            highVal=Math.max(highVal,matrix[i][C-1]);// finding highest element
        }
        
        
       
        
        
        while(lowVal<=highVal){
            int midVal=(lowVal+highVal)/2;
            int ans=0;// to store count of element that is <= midVal
            for(int i=0;i<R;i++){// for each row apply binary search where target will be midVal
                int low=0;
                int high=C-1;
                while(low<=high){
                    int mid=(low+high)/2;
                    if(matrix[i][mid]>midVal){
                        high=mid-1;
                    }
                    else{
                        low=mid+1;
                    }
                }
                ans+=low;// mid+1 = low i.e mid+1 will be the count
            }
            if(ans<= totalElement/2){
                lowVal=midVal+1;
              
                
            }
            else{
                highVal=midVal-1;
            }
            
        }
        return lowVal;
    }
}