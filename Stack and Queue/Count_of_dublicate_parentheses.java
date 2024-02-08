// time complexity is O(n);
// if current Character and just the peek character are opposite to each other then there is dublicate charater
// to solve this we push everything in the stack until ) is not found
// when ) is reached we check if the top of stack is ( or not if yes then it has dublicates
// if not then pop all the element until ( is not found 
// we also take count if count==0 that means there is an extra ) and if count == 1 that mean the peek was ( 
// hence it has dublicate so we return 1
class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length() ; i++){
            Character ch = s.charAt(i);
            if(ch != ')'){ // pushing all character into the stack other than )
                stack.push(ch);
            }else{
                int count =0;
                while(stack.peek() != '('){ // if stack peek()!= (  we revmove all the character from stack until ( is not found and increase the count)
                    stack.pop();
                    count++;
                }
                stack.pop(); // balancing ( parentheses is to be popped as well
                if(count ==0 || count ==1){
                    // count ==0 mean extra ) bracket is there
                    // count ==1 means just the top of the stack has ( which was not required 
                    // this means nothing was there in between those two bracket and was uncessary to include in equation
                    
                    return 1;
                }
            }
        }
      
        return 0;
    }
}
             
