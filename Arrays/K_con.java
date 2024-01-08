// time complexity will O(n*k) where k=2;
//here will be three cases
// if k==1
// simply apply kadanes algo in the given Array
// if k>1
// calculate the sum of all element 
// then if sum>0
// then calculate kadanes sum of two array 
// then final result=maxSum+(k-2)*sum
//k-2 because we already calculated 2 array kadanes sum 
// k-2* sum because sum in each array will contribute to the answer
// and if sum<0
// then final answer will be the kadanes sum of 2 array
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while (t-- > 0) {
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int a[] = new int[n];
	        for (int i = 0; i < n; i++) {
	            a[i] = sc.nextInt();
	        }
	        System.out.println(compute(a, n, k));
	    }
	}
	
	static long compute(int a[], int n, int k) {
	    long tsum = 0;
	    for (int x : a) tsum += x;// calculating total sum of array elements
	    long csum = 0, msum = Integer.MIN_VALUE;
	    int range = 2*n; // if k>1 then we calculate the kadanes sum of two array
	    if (k==1) range = n; // when k=1 
	    for (int ind = 0; ind < range; ind++) {
	        int i = ind % n; // to revise the index for 2nd array
	        if (csum < 0) csum = a[i];
	        else csum += a[i];
	        msum = Math.max(msum, csum);
	    }
	    if (tsum >= 0 && k >= 2) { // if sum is positive
	        msum += tsum * (k-2);
	    }
	    return msum; // if sum is negative or k=1;
	}
}
