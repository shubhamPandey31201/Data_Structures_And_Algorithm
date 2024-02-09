// User function Template for Java
// time complexity is O(N)
// simply push first K element in the stack 
// now start pop those element in adding it into same queue
// there after adding stack element into the queue 
// it will be in reverse order but it is added after n-k element
// so for n-k element poll it from queue and add back to the queue at same time
class GfG {
    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++){// adding k element into the stack
            st.push(q.poll());
            
            
        }
        
        for(int i=0;i<k;i++){// poping and adding the element of stack into the queue
            q.add(st.pop());
        }
        int i=1;
        while(i<=q.size()-k){ // polling and adding n-k element from same queue to same queue
            q.add(q.poll());
            i++;
        }
        return q;
        // add code here.
    }
}
