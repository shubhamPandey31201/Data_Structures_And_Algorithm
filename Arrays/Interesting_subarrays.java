// time complexity is O(N)
// we need to find interesting subarray
// interesting subarry is the subarray whose difference of max and min element is >= the length of subarray
// for single length subarray max and min will be same element so diff will be 0
// for double length subarray max-min should be greater >= 2
// so we find if two consecutive element difference is >= 2 or not 
// if it satisfies this condition it will satisfy for >2 size subarray as well
// else it wont satisfy
import java.util.*;

public class Codeforces{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
                
            }
            boolean check=false;// if interesting subarray is not found
            for(int i=0;i<n-1;i++){
                int val1=a[i];// two consecutive element
                int val2=a[i+1];
                int diff=Math.abs(val1-val2);
                if(diff>=2){ // difference is >=2 then it is an interesting subarray
                    System.out.println("YES");
                    System.out.print(i+1);
                    System.out.print(" ");
                    System.out.println(i+2);
                    check=true;
                    break;
                }
            }
            if(!check)
                System.out.println("NO");
        }
    }
}