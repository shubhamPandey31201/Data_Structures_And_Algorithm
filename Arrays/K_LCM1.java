
// in this question we are basically given n and k 
// where n is a number that has to be divided in k=3 parts such that 
// it satisfies two conditions 
// that are
// 1. n1+n2+n3 = n and 2. lcm of(n1,n2,n3)<=n/2
// to solve this condition we need to consider two cases
// one is if the number n is odd and other is if the number n is even 
// if n is odd then three numbers will be n/2 , n/2 and 1
// if n is even then again we will have two cases i.e n/2 is odd or even
// n%4==0(this means n/2 is even) then three numbers will be n/2 ,n/4,n/4
// if n/2 is odd then three numbers will be n/2-1,n/2-1,2.
// first dry run this condition and understand then solve the question 

import java.util.*;

public class Codeforces{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            // taking input
            
            int n=sc.nextInt();
            int k=sc.nextInt();
            StringBuilder sb=new StringBuilder();
            ArrayList<Integer> res=new ArrayList<>();
            
            
            if(n%2==0){// when n is even
                if(n%4==0){// when n/2 is even
                    
                    res.add(n/2);
                    res.add(n/4);
                    res.add(n/4);
                }
                else{// when n/2 is odd
                    res.add((n/2)-1);
                    res.add((n/2)-1);
                    res.add(2);
                    
                }
                
            }
            else{ // when n is odd
                res.add(n/2);
                res.add(n/2);
                res.add(1);
                
                
            }
            for(int e:res){
                System.out.print(e + " ");
            }
            System.out.println();
            
        }
    }
}