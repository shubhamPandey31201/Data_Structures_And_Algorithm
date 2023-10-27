// if n is the upper range make new boolean array of size n+1 
// respective to index value number will be mapped that is why n+1 size
// mark true for all value first
// since 0,1 is not prime ignore them and start iterating from 2 to i*i<=n
// for  root n complexity i*i<=n
// if arr[i]==true
// mark false for multiple of i
// if arr[i]==false that means already multiple of i is false
// run another loop from 2 to <n;
// increment count if arr[i]==true;

class Solution {
    public int countPrimes(int n) {
        boolean[] arr=new boolean[n+1];
        int count=0;
        
        Arrays.fill(arr,true);// marking every value as true
        for(int i=2;i*i<=n;i++){
            if(arr[i]==true){
                
                for(int j=i+i;j<n;j+=i){ // marking false for multiple of i
                    arr[j]=false;
                }
            }
        }
        // for counting prime numbers
        for(int i=2;i<n;i++){
            if(arr[i]==true){
                count++;
            }
        }
        return count;
        
    }
}