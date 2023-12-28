
//question is to find the nth power of some number x
// our objective is to find the power in O(logn) complexity
// for example x=2 and n=8
// this will be as 2^8 
// this can also be written as (2^2)^8/2
// further more (4^2)^4/2 and so on till n> 0
// now if n is odd then we simply multiply x with the ans and decrement n by 1

class Solution {
    public double myPow(double x, int n) {

        double ans=1.0; // ans  
        long z=n; // if -n is large to convert that in positive
       

        boolean flag= false; // when n is positive
        if(z<0){ 
            flag=true; // when n is negative 
            z=-z; // making n positive
            
        }
       

        while(z>0){
            if(z%2==1){ // if z is odd
                ans=ans*x; // multiply ans with x
                z--; // drecement z
            }
            // for normal case 
            x=x*x; 
            
            z/=2; 
        }

        if(flag==true){ // when n was negative it will be  1/x^z
            
            return 1.0/ans;
        }
        return ans; // when n is positive
        
        
    }
}