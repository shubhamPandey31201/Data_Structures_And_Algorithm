//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Driverclass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            System.out.println(new Solution().countOccurence(arr, n, k));
        }
    }
}

// } Driver Code Ends

// In this question we have to return the number of element whose occurence is greater than
// n/k
//time complexity O(n)

// we store the frequency of each element in the hashmap
class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    
    
    {
        HashMap<Integer,Integer> frequency= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // if element aready exist in the hashmap add 1 to the corresponding value of the key
            if(frequency.containsKey(arr[i])){
                frequency.put(arr[i],frequency.get(arr[i])+1);
            }
            else{
                // if element is not present the mean its the first occurence
                frequency.put(arr[i],1);
            }
            
        }
        int count=0;
        // iterating on keys of hashmap
        for(int e:frequency.keySet()){
            if(frequency.get(e) > n/k){
                count++;
                
            }
        }
        
        return count;
        
        // your code here,return the answer
    }
}
