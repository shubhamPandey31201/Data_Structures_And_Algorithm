// we have been give an array we just have to reorder the array in such away that the sum of mex of prefix array is maximum
// when the array is sorted the sum of mex of prefix arrays is maximum always 
// there should not be dublicate element consecutively 
// we should add the dublicate element at the last of the array // doing this will increase the mex value
// in this way sum of max will be maximum
// time complexity is O(n)

import java.util.*;

public class Codeforces_Meximization{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        while(t-- > 0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                
            }
            
            Arrays.sort(arr); // first sorting array
            ArrayList<Integer> dublicate = new ArrayList<>();
            
            System.out.print(arr[0]+" "); // handling index out of bound exception
            for(int i=1;i<n;i++){
                if(arr[i]!=arr[i-1]){
                    System.out.print(arr[i]+" "); // if not dublicate print it
                }
                else{
                    dublicate.add(arr[i]); // store dublicate element in arraylist
                }
                
            }
            for(int i=0;i<dublicate.size();i++){
                System.out.print(dublicate.get(i)+" "); // atlast print the element in the arraylist
            }
            
            System.out.println();
        }
    }
}