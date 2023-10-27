//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            new Solution().segregate0and1(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java
// apply partiting technique
// i to ending all elements are unknown first
// j to i-1 is area for 1 values
// i to j-1 is area for 0 values

// two condition if a[i]==0 then swap(j,i) values and i++ also j++
// if a[i]=1 simply i++;

class Solution {
    
    // swapping function
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void segregate0and1(int[] arr, int n) {
        // code here
        int i=0;// finding 0
        int j=0; // starting area of 1
        
        while(i<n){
            if(arr[i]==0){ // case i
                swap(arr,i,j);
                i++;
                j++;
            }
            else{ // case ii when arr[i]==1
                i++;
            }
        }
    }

}
