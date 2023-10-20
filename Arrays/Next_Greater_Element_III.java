
// This question simply ask to return just greater number than the given number
// The number should contain exactly same digit
// steps we have to check the deflection point 
// deflection point is the point there the first element is lesser than the next one
// make that deflection as first swapping point 
// find the second swapping point
// second swapping point will be the number just greater than firstswapoing number
// so to find second swapping point we just find it from the first swapping point to the last index
// after finding the first swapping and second swapping point we just swap them with each other
// then we reverse the number after first swapping point to make it smallest among the just greater number
public class Solution {
    int nextGreaterElement(int n) {
        String strNum= Integer.toString(n);// converting integer value to string
        char ch[]=strNum.toCharArray();// converting into char array

        int len=ch.length;


        int firstSwappingPoint=len-1;

        while(firstSwappingPoint>0){
            if(ch[firstSwappingPoint]>ch[firstSwappingPoint-1]){
                firstSwappingPoint--; //finding first swapping point
                break;
            }
            firstSwappingPoint--;
        }
        if(firstSwappingPoint == -1){
            return -1; // when the first digit is the largest digit 
                // array is in descending order then we cannot form greater 
                // than that
        }
        int secondSwappingPoint=len-1;

        while(secondSwappingPoint>firstSwappingPoint){
            if(ch[secondSwappingPoint]>ch[firstSwappingPoint]){
                break; // finding second swapping number
            }
            secondSwappingPoint--;
        }
        // swapping first swapping number and second swapping number 
        // inorder to make it just greater

        char temp=ch[firstSwappingPoint]; 
        ch[firstSwappingPoint]=ch[secondSwappingPoint];
        ch[secondSwappingPoint]=temp;

        // reversing the element after first swapping point to make it smallest

        reverse(firstSwappingPoint+1,len-1,ch); // reverse function

        

        String ansStr=String.valueOf(ch); // converting array into string
        long ansLong=Long.parseLong(ansStr); // converting string into long
        int result=(int) ansLong; // typecasting long into int
        if(result>n){
            return result;
        }
        return -1;// if the number is not greater then return -1
        
    }
    // reverse function
    static void reverse(int sIdx,int eIdx,char ch[]){
            while(sIdx<eIdx){
                char temp=ch[sIdx];
                ch[sIdx]=ch[eIdx];
                ch[eIdx]=temp;
                sIdx++;
                eIdx--;
            }
        }
}