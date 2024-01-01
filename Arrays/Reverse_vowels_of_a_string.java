//time complexity is O(n)
// double pointer is used to solve
// move i and j pointer until you get vowel and 
// when both ith and jth element is vowel swap
class Solution {
    public static boolean isVowel(char ch){ // checking if the ith or jth element is vowel or not
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'|| ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
            return true;
        }
        return false;
    }
    public static void swap(char[] arr, int i ,int j){ // swapping function || when ith element and jth element is vowel
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }
    public String reverseVowels(String s) {
        char[] arr=s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<j){
            while(i<j && !isVowel(arr[i])){ // skipping consonant letter from ith side || inner loop is dependent to outer loop that is why i<j
                i++;
            }
            while(i<j && !isVowel(arr[j])){ // skipping consonant letter from jth side
                j--;
            }
            swap(arr,i,j);// swaping vowels 
            i++; 
            j--;
        }
        String str="";
        for(int k=0;k<arr.length;k++){
            str+=arr[k];
        }
        return str;

        
    }
}