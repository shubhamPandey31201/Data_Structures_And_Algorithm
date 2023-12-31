//time complexity is O(n^2)
// here we use child logic of multiplication

class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){ // if either of them is 0 return 0 as answer
            return "0";
        }

        int [] resultArr=new int[num1.length()+num2.length()]; // the resultant array will be max of sum of length of two array 
        
        int productFactor=0; // vvi concept. digit place in resultant array
        

        
        for(int i=num2.length()-1;i>=0;i--){

            int iVal=num2.charAt(i)-'0'; // converting into int
            int k=resultArr.length - 1 - productFactor; // k is the pointer in the resultant array
            
            int j=num1.length()-1;
            int carry=0; // start of every multiplication carry will be 0
            
       


            while(j>=0 || carry!=0){ // there might be case when j<0 but carry is > 0 that time multiplication is done with 0 and carry is added to that
                
                int jVal=(j<0)? 0:num1.charAt(j)-'0'; // handling index out of bound exception when carry > 0 but j<0 we assign jval as 0
                

                int product= iVal*jVal+carry+resultArr[k]; // formula for prodcut
                resultArr[k]=product%10;
                carry=product/10;
                
                k--;
                j--;
                


            }
            productFactor++;
            
            

        }
        String ans="";
        int l=0;
        boolean flag=false; // for removing leading zero
        while(l<resultArr.length){
            if(resultArr[l]==0 && flag==false){
                l++;
            }
            flag=true; // when leading zero's are removed
            ans+=resultArr[l];
            l++;

        }
        return ans;
        
    }
}