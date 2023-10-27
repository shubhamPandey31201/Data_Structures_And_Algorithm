// time complexity is O(n)
// f(n)=f(n-1)+f(n-2)
// last two line is program for recursive function
class Solution {
    public int fib(int n) {
        
        int a=0;
        int b=1;
        if(n==0) return 0;
        if(n==1) return 1;
        for(int i=2;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
        // if(n<=1) return n;
        // return fib(n-1)+fib(n-2);
    }
}
