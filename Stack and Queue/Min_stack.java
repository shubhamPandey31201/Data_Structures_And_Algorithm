// Time complexity is O(1)
// we make two stack one will be normal stack and other will be minStack
// we push all element in normal stack and we push only those element to the stack which is smaller than the peek of minStack
// if minStack is empty also we push element whatever is encountered
// while poping we pop from normal stack and if normal Stack peek is equal to minStack peek we pop from both stack
// top we just peek() from normal stack
//for get min we return peek of minStack

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;

    public MinStack() {// initialising both stack
        st=new Stack<>();
        minSt=new Stack<>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.size()==0 || minSt.peek()>=val){ // for minStack 
            minSt.push(val);
        }
        
    }
    
    public void pop() {
        if(st.size()==0){ // underflow
            return ;
        }
        int element=st.pop();
        if(minSt.size()>0 && element==minSt.peek()){ // when both in st and minSt top is equal pop both
            minSt.pop();
        }
        
    }
    
    public int top() {
        if(st.size()==0){ // under flow
            return -1;
        }
        return st.peek();
        
    }
    
    public int getMin() {
        if(minSt.size()== 0){// underflow
            return -1;
        }
        return minSt.peek(); // return peek
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */