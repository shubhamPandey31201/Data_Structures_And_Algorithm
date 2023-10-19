// Relatively prime and co-prime are same and this means two number whose gcd is 1
// in this problem inclusive range is given such that total number between them is even
// and difference between them is odd 
// we need to find co-prime between them in exactly half pairs and if the pairs are possible
//print yes else no 
// the the pairs will always be there so for every test case answer will be yes
// we cannot form odd and even number pairs cause its gcd maynot be 1 for example 3 and 6
// but two consecutive number gcd is always one 
// there for we print two consecutive number 
// we use StringBuilder because we can append in it but in string cannot
//time complexity is O(n)
import java.util.*;
public class Codeforces{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long l=sc.nextLong(); // according to input constraint
        long r=sc.nextLong();
        StringBuilder sb=new StringBuilder(); // for appending
        sb.append("YES\n");
        
        for(long i=l;i<=r;i+=2){// i+=1 because we are printing a pair at once
            sb.append(i+" "+(i+1)+"\n");
        }
        System.out.println(sb);
    }
}
