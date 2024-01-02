//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

// time complexity is O(n)
// in this question for a given k we need to return minimum number of swap required to get <=k element together
// we use sliding window protocol
// where size of the window will be the favourable element count
// where favourable element are the element lesser than or equal to k
// after finding favouralbe element find the nonFavourable inside that first window
// the number of nonFavourable element inside the window will be the number of swaps required
// will keep on moving windows and calculate min nonFavourable window in each window
// the window containing least nonFavourable element will be the answer

class Complete{
    
   
    // Function for finding maximum and value pair
    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int favourable=0,nonFavourable=0;
        
        // finding the Favourable element count
        for(int i=0;i<n;i++){
            if(arr[i]<=k){
                favourable++;
                
            }
        }
        int i=0;
        int j=favourable;
        int result=Integer.MAX_VALUE;// initializing window with the max value
        // finding the nonFavourable elment count in first window
        while(i<j){
            if(arr[i]>k){
                nonFavourable++;
            }
            i++;
            
        }
        
        result=Math.min(nonFavourable,result);// updating window with nonFav count 
        int l=favourable;
        int r=0;//for detecting if the first element of the window is fav or nonFav
        // moving window by one index
        
        while(l<n){
            if(l<n && arr[r]>k){ // when first element of window is non fav 
                nonFavourable--;
                
                
                
            }
            if(l<n && arr[l]>k){ // when first element of window is fav
                nonFavourable++;
                
            }
            result=Math.min(nonFavourable,result); // updating result with each window non fav count
            r++;
            l++;
            
        }
        
        return result; 
        
    }
    
    
}
