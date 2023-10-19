
// Question has an array of cream quantity
// this is a stack type of question
// so we start from last index and apply cream on cake
import java.util.*;
 
public class Napolean_cake{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        
        // test case input
        
        int t=sc.nextInt();
        
        while(t-- > 0){ // test case condition
            int n=sc.nextInt(); // array size input
            int arr[] = new int[n]; // cream array input
            
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
            }
            StringBuilder sb=new StringBuilder(); // string builder to append 
            int temp=arr[n-1];// current quantity of cream available
            for(int i=n-1;i>=0;i--){
                if(arr[i]>=temp){ // if current index has more cream avaiable then exchange with that
                    temp=arr[i];
                }
                if(temp>0 && temp>=arr[i]){ // if temp quantity currently is greater than 0 that means cream can be added so add 1
                    sb.append("1 ");
                    temp--;
                }
                else{
                    sb.append("0 "); // else add 0
                }
            }
            System.out.println(sb.reverse().toString().trim());
            // since we added values from last to first we need to reverse then convert it to string and then by using trim we can remove extra spaces from start and end 
        }
    }
}