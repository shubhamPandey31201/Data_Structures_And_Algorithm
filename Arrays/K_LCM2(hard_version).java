// to understand this question first learn k_lcm (easy version);
// we in k_lcm (easy version k value was 3) but in hard version k value is variable
// so we convert value of k to 3
// for example k value is 6 so we add 3 one's in our answer since 1 affect nothing in lcm
// and if n is the number we reduce it to n-(k-3); 
// and on n-(k-3) we apply easy version;
import java.util.*;

public class Codeforces{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            ArrayList<Integer> ans= new ArrayList<>();
            int Ktemp=k-3; // calculating how many number of one's should be added
            int Ntemp=n-Ktemp; // calculating the number one which K-lcm easy version algo to apply
            if(Ntemp%2 == 0){ // if n  even
                if(Ntemp%4==0){ // after n/2 if even
                    ans.add(Ntemp/2);
                    ans.add(Ntemp/4);
                    ans.add(Ntemp/4);
                    for(int i=1;i<=Ktemp;i++){ // adding remaining ones
                        ans.add(1);
                    }
                    
                }
                else{// if n/2 is odd
                    ans.add((Ntemp/2)-1);
                    ans.add((Ntemp/2)-1);
                    ans.add(2);
                    for(int i=1;i<=Ktemp;i++){// adding remaining ones
                        ans.add(1);
                    }
                    
                }
                
            }
            else{ // if n is odd
                ans.add(Ntemp/2);
                ans.add(Ntemp/2);
                ans.add(1);
                for(int i=1;i<=Ktemp;i++){ // adding remaining ones
                    ans.add(1);
                }
            }
            for(int e:ans){
                System.out.print(e+" ");
                
            }
            System.out.println();
            
        }
    }
}