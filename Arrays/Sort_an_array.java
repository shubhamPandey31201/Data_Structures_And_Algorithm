import java.util.*;
// time complexity is O(nlogn)
// question is to return yes if a segment of an array is reverse and that result in sorting of the entire array

// first we copy the element of array into another array
// we sort the array 
// then we check for the first misMatch element from LHS and store the index
// then we check for the first misMatch element from RHS and store the index
// then we reverse the array from LHS index and RHS index
// then compare the reversed array with the sorted array 
// if same return answer as yes else no
public class Codeforces{
    public static void reverse(int a[],int i,int j){
        while(i<j){
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            a[i]=arr[i];// coping element into another array
            
        }
        
        Arrays.sort(arr);// sorting array
        int leftMismatch=-1;
        int rightMismatch=-1;
        
        
        for(int i=0;i<n;i++){// calculating leftMismatch
            if(a[i]!=arr[i]){
                leftMismatch=i;
               
                break;
                
            }
            
        }
        for(int i=n-1;i>=0;i--){// calculating rightMismatch
            if(a[i]!=arr[i]){
                rightMismatch=i;
               
                break;
            }
        }
        reverse(a,leftMismatch,rightMismatch);//reversing
        
        
        for(int i=0;i<n;i++){// checking if both the array are sorted or not
            if(a[i]!=arr[i]){
                System.out.println("no");
                return;
            }
        }
        if(leftMismatch==-1){ // when the array was already sorted single element or the first element will be reversed with itself
            System.out.println("yes");
            System.out.println(1+" "+1);
            return;
            
        }
       
        System.out.println("yes");
        System.out.print(leftMismatch+1);
        System.out.print(" ");
        System.out.println(rightMismatch+1);
        
        
    }
}