//time complexity is O(n^2)
// for give k value you can swap any element from the string from begining k element and return the smallest possible string 
// for k>1 the array will always be sorted always// so we directly sort the string
// for k=n that mean can array be sorted with n number of swaps
// if k==1 so we use brute force we move the first element to the last n number of times and check if it is smallest then the previous smallest or not 
// and at last return the smallest answer
class Solution {
    public String orderlyQueue(String s, int k) {
        char arr[]=s.toCharArray();
        String ans=s;
        if(k>1){ // answer will always be in sorted order
            Arrays.sort(arr);
            return String.valueOf(arr);


        }
        else { // when k==1 // use brute force
            for(int i=0;i<arr.length;i++){
                char temp=arr[0]; // ever first element is moved at last
                for(int j=1;j<arr.length;j++){// shifting all element forward
                    arr[j-1]=arr[j];
                }
                arr[arr.length-1]=temp; // element temp at last index
                String str=String.valueOf(arr); // converting to string
                
                if(ans.compareTo(str)>0){ // comparing with previous answer
                    ans=str; // if current string is shortest 
                }

            }
        }
        return ans;
        
    }
}