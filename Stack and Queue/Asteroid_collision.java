//Time complexity is O(n)
// we just have to handle few cases
// first we check if the value is >0 or not 
// we it is then it is pushed into the stack 
// else if it is <0 we see if the stack top is positive or not and stack top is less than absolute of current value
// if so pop the value ( collision occurs)
// else if both top and current value are equal then too pop
// else if stack top is greaer than absolute of current value then skip pushing of current element
// else push the element into the stack
// at last pop out all the element into the array
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i]>0){// when current value is > 0 only pushing is done
                st.push(asteroids[i]);
            }
            else{
                while(st.size()>0 && st.peek()>0 && st.peek()< -asteroids[i]){ // when current value is < 0 and is greater than top of stack then pop the value
                    st.pop();
                }
                
                if(st.size()>0 && -asteroids[i]==st.peek()){// when top and current value is equal
                    st.pop();
                }
                else if(st.size()>0 && st.peek()> -asteroids[i]){// when top is greater than current value skip the pushing of current value

                }
                else{
                    st.push(asteroids[i]);// when stack is empty  or top is negative elment
                }

            }
            

        }
        int len=st.size();
        int[] ans=new int[len];
        for(int i=len-1;i>=0;i--){// adding element of stack to array
            ans[i]=st.pop();
        }
        
        
        return ans;
        
    }
}