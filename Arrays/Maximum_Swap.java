// time complexity is O(n)
// question is to find the maximum number that is obtained by a singel swap of two digit
// first conver integer number into character array
// create array and the find the last occurence of digit(0-9) in the character array 
// the compare if the current element index and from 9 to current element index is smaller or not 
// if current element index is smaller than swap
class Solution {
    public int maximumSwap(int num) {
        String n= Integer.toString(num);
        char [] numArr= n.toCharArray();
        int lastIdx[]= new int[10];

        for(int i=0;i<numArr.length;i++){//storing last occurrence index of digi
            lastIdx[numArr[i]-'0']=i;
            

        }
        
        boolean flag=true;// for stopping in middle just after once swap
        for(int i=0;i<numArr.length;i++){
            int digit=numArr[i]-'0';// for converting into int
            for(int j=9;j>digit;j--){ // for checking if larger number has greater index or not
                if(lastIdx[j]>i){ // if yes then swap
                    char temp=numArr[i];
                    numArr[i]=numArr[lastIdx[j]];
                    numArr[lastIdx[j]]=temp;
                    flag=false;
                    break;

                }

            }
            if(flag==false) break;
        }
        
        String res=String.valueOf(numArr);
        long ans=Long.parseLong(res);
        int result=(int) ans; // again converting into int
        return result;
    }
}