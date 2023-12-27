import java.util.*;
import java.lang.*;
// time complexity o(nloglog(n))
// steps involved 
// here two ranges are give a to b 
// so we map a with 0th index and b with the last index 
// first will calculate all the primes from 0 to rootb by seive of erathothenes
// secondly will calculate the multiple of the primes that we get 
// thirdly will find the starting index of the multiple of the primes that exist in the range
// and then again apply seive of erathothenes in that
//
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	
	{
		Scanner sc= new Scanner (System.in);
		int t= sc.nextInt(); // input for test case
		while(t-- > 0){
			int a= sc.nextInt();
			int b= sc.nextInt();
			
			
			// generate prime number from 0 to root  b  by seive of erathothenes
			int rootb= (int) Math.sqrt(b);
			boolean arr[] = new boolean[rootb+1];
			arr[0]=true;
			arr[1]=true;
			ArrayList<Integer> rootbPrimes= new ArrayList<>(); // store all prime numbers from 0 to root b
			
			for(int i=2;i<=rootb;i++){
			    if(arr[i]==false){
			        for(int j=i+i;j<=rootb;j+=i){
			            arr[j]=true;
			        }
			    }
			}
			for(int i=0;i<=rootb;i++){
			    if(arr[i]==false){
			        rootbPrimes.add(i);
			    }
			}
			boolean[] resultPrimes=new boolean[b-a+1]; // default the value of boolean array will be false
			
			for(int primes:rootbPrimes){ // for every prime number till rootb will find multiple and starting index
			    int multiple=(int) Math.ceil((a*1.0)/primes);
			    if(multiple==1) multiple++; // edge case cause for 2 multiple will come 1 which is not valid so we increment
			    int startingIndex=multiple*primes - a; // starting index of a number that is in the range
			    for(int i=startingIndex;i<resultPrimes.length;i+=primes){ // seive of erathothenes
			        resultPrimes[i]=true; 
			    }
			    
			}
			for(int i = 0;i<resultPrimes.length;i++){
			    if(resultPrimes[i]==false && i+a>1 ){ // the number should be greater than 1 so i+a>1
			        System.out.println(i+a);
			    }
			}
			
			
		}
	
	}
}