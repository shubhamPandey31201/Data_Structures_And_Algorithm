//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java
// time complexity O(n)
// divide the array into three regions
// i to k unknown
// 0 to j-1 for 0's
// j to i-1 for 1's
// k+1 to end for 2's

// three cases
// case i when a[i]=0 then swap(a,i,j) i++ and j++
// case ii when a[i]=1 then i++;
// case ii when a[i]=2 then swap(a,i,k) k--;




class Solution

{
    static void swap(int a[],int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    public static void sort012(int a[], int n)
    
        
    {
        // initializing i,j,k
        int i=0;
        int j=0;
        int k=n-1;
        
        while(i<=k){
            if(a[i]==0){ // case i
                swap(a,i,j);
                i++;
                j++;
            }
            else if(a[i]==1){ // case ii
                i++;
            }
            else{// ifa[i]==2 case iii
                swap(a,i,k);
                k--;
                
            }
            
        }
        // code here 
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends