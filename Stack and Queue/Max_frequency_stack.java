//Time Complexity O(n)
// make two hashmap 
// first hashmap contains frequency as key and stack as value
// second hasmap contains value as key and its frequency as value
// also there is maxFrequency variable than contains max frequency as current


class FreqStack {
    HashMap<Integer,Stack<Integer>> freqToStack;
    HashMap<Integer,Integer> freq;
    int maxFreq;

    public FreqStack() {// constructor to initialise hashmaps and maxFreq
        freqToStack=new HashMap<>();
        freq=new HashMap<>();
        maxFreq=0;
        
    }
    
    public void push(int val) {
        int currFreq=freq.getOrDefault(val,0); // for a value we find the currFrequency and there doesnot exist such value than default will be 0
        currFreq++; // after getting current frequency then increment the frequency
        freq.put(val,currFreq); // put back the incremented freqency back to the frequency map 
        if(freqToStack.containsKey(currFreq)==false){ // when new frequency is introduced new stack is initialised
            freqToStack.put(currFreq,new Stack<Integer>());
        }
        
        Stack<Integer> st=freqToStack.get(currFreq); // first we get the stack correstponding to current frequency
        st.push(val);// push the current value to respective stack 
        maxFreq=Math.max(maxFreq,currFreq);// update max freq with current freq
        
        
    }
    
    public int pop() {
        if(maxFreq==0){ // for pop if maxFrequency is 0 means there is no stack in the hashMap so popping is not possible
            return -1;
        }
        Stack<Integer> st=freqToStack.get(maxFreq);//get the respective stack from where we need to pop . here corresponding to maxFreq key we need to pop
        int popped=st.pop();
        int currFreq=freq.get(popped);/// we need to pop the element and then decrement its frequency in frequency map 
        currFreq--;
        freq.put(popped,currFreq);// again putting decremented current frequency into the map 
        if(st.size()==0) maxFreq--;// also if the stack size is 0 that mean no element has frequency to that maxFre value so maxFreq is decremented
        return popped;// popped value is returned

        
    }
}



/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */