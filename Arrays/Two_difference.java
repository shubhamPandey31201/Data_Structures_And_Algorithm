//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int l = sc.nextInt();
            int n = sc.nextInt();
            
            int arr[] =  new int[l];
            
            for(int i = 0;i<l;i++)
                arr[i] = sc.nextInt();
            
            Solution ob = new Solution();
                
            if(ob.findPair(arr, l, n)==true)
                System.out.println(1);
                
            else
                System.out.println(-1);    
                
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

// to solve this question we need to solve two sum question first
// time and space complexity is O(n)
// the only difference is there can be two required cases one is target+currentVal 
// and other Math.abs(target-currentVal)
// for example if target is 78 then and current value is 80 then required value can be 80+78 or 80-78

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        HashMap<Integer,Integer> elementIndex = new HashMap<>(); // strong current element with index
        // hashmap is used for searching the required element
        
        for(int i=0;i<size;i++){
            int val=arr[i];
            int required1=n+val;
            int required2=Math.abs(val-n);
            if(elementIndex.containsKey(required1) || elementIndex.containsKey(required2)){ // searching if array consist required element
                return true;
            }
            elementIndex.put(val,i);
        }
        return false;
        
        //code here.
    }
}