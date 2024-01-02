//time complexity is O(n)
// here a string of current state of dominos is given before pushing
// after pushing what will be state of dominos is be returned in the form of string
// in this question first we add L dominos at first and R dominos at last
// then we divided the entire string into segments 
// where segments will have only . in between directed dominos for exam R....L
// these segment will have four cases
// first R....R here after pushing all dots will be right after pushing
// second L....L here after pushing all dots will be left 
// third L....R here no changes will be there
// fourth R....L here again two cases will be there
// if there is odd dots in between there will a dominos that will be balance by R and L dominos so a single dominos will remain as it was rest half will be R and other half will be L
// if there is even dots in between there will be half R and other half will be L
// we should use StringBuilder cause if we use String it take more time for concatenation

class Solution {
    public static void evaluateSegment(char arr[],int i,int j){
        int k=i+1;
        if(arr[i]=='L' && arr[j]=='L'){ // all will be L
            
            while(k<j){
                arr[k]='L';
                k++;
            }
        }
        else if(arr[i]=='R' && arr[j]=='R'){ // all will be R
            
            while(k<j){
                arr[k]='R';
                k++;
            }
        }
        else if(arr[i]=='L' && arr[j]=='R'){ 
            // no change in the segment
            
            
        }
        else if(arr[i]=='R' && arr[j]=='L'){
            int mid=(i+j)/2; // finding mid
            
            if((i+j)%2==0){ // when there are odd dots in middle
                while(k<mid){ // mid element will remain as . (unchanges)
                // first half will be R
                    arr[k]='R';
                    k++;
                }
                k=mid+1;
                while(k<j){
                    // second half will be L
                    arr[k]='L';
                    k++;
                }

            } 
            else{
                // when there is even dot even mid is included 
                while(k<=mid){
                    // first half will be R
                    arr[k]='R';
                    k++;
                }
                k=mid+1;
                while(k<j){
                    // second half will be L
                    arr[k]='L';
                    k++;
                }
            }
            
           
        }
        return;
       
        
       
       

    }
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        char[] arr=new char[n+2]; // increasing arr length by 2 for adding L and R dominos
        arr[0]='L'; // adding L at first 
        arr[n+1]='R'; // adding R at last
        for(int i=1;i<n+1;i++){
            arr[i]=dominoes.charAt(i-1); // converting string dominoes into array
        }
        
        int i=0;
        int j=1;
        while(j<n+2){
            while(arr[j]=='.'){ // from i to j it will be a segment
                j++;
            }
            evaluateSegment(arr,i,j); // after finding segment we solve the segement
            i=j;// next segment starts from j
            j++; // j incremented
        }
        StringBuilder sb=new StringBuilder(); // for space and time optimization
        for(i=1;i<n+1;i++){
            sb.append(arr[i]);
            
        }
        return sb.toString();

        
    }
}