// Time complexity is O(n)
// the intituition of this question is that we first add 1 to queque and run loop till N 
// first 0 is added and then 1 is added to popped string and then popped in its consecutive turn

class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        Queue<String> bi=new LinkedList<>();
        ArrayList<String> result=new ArrayList<>();
        bi.add("1");// first 1 is added to queue
        while(N>0){
            String str=bi.poll();
            bi.add(str+"0");// adding 0 to popped element and pushing it to queue
            bi.add(str+"1");// adding 1 to popped element and pushing it to queue
            result.add(str);// adding the poppped element to the answer arraylist
            N--;// decresing N count
        }
        return result;
        // Your code here
    }
    
}
