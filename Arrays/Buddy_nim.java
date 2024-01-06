/* package codechef; // don't place package name! */
// time complexity will be 0(n)
// this is a game theory related question 
// here in this game there are three players charlie alice and Bob
// the task is to win the game by saving stones on the table. whosoever looses their all the stone on the table will looses
// charlie supports alice by swapping the table with maximum number of stones
// at a time any number of stones in the single stack can be removed
// first charlie turn then alice then bob turn
// there will be three cases 
// first if the number of stones are not equal then every time alice will only win 
// second if the numbers are equal then there will be two cases 
// i> if structure is same then bob will win // because bob's turn is at last
// ii> if structure is not same then alice will win // because at some point of the number of stones will be uneven 
// there is no role of 0 in the array so we remove or ignore 0

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
	  	Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    while(t-->0){
	        
	        int m=sc.nextInt();
	        int n=sc.nextInt();
	       // int a[]=new int[m];
	       // int b[]=new int[n];
	       ArrayList<Integer> a=new ArrayList<>();
	       ArrayList<Integer> b=new ArrayList<>();
	        for(int i=0;i<m;i++){
	            int num=sc.nextInt();
	            if(num!=0) // excluding 0
	            a.add(num);
	        }
	       
	        for(int i=0;i<n;i++){
	            int num=sc.nextInt();
	            if(num!=0)
	            b.add(num);
	        }
	      
	       Collections.sort(a); // sorting for comparison
	       Collections.sort(b);
	        System.out.println(func(a,b));
	    }
	}
	public static String func(ArrayList<Integer> a, ArrayList<Integer> b){
	  if(a.size()!=b.size()) return "Alice"; // if size is not equal that mean structure is not same or number of stones are not equal so alice wins
	  else{
	      if(a.equals(b)) return "Bob";// structure is same
	      else return "Alice";  // structure is not same
	  }
	}
}