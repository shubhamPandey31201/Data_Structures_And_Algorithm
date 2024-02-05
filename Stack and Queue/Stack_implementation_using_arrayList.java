import java.util.*;
public class Stack_implementation_using_arrayList {
    int top=-1;
    ArrayList<Integer> arr;
    public Stack_implementation_using_arrayList(){
        arr=new ArrayList<Integer>();

    }

    public  void push(int val){
        top++;
        arr.add(val);


        
        
    }
    public  int peek(){
        if(top==-1){
            return  Integer.MIN_VALUE;
        }
        return arr.get(top);

    }
    public  int poll(){
        if(top==-1){
            System.out.println("stack underbound");
            return Integer.MIN_VALUE;

        }
        int val=arr.get(top);
        top--;
        return val;
    }
    int size(){
        return ++top;
    }
    public static void main(String[] args){
        Stack_implementation_using_arrayList stack = new Stack_implementation_using_arrayList();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.poll());
        System.out.println(stack.size());

        


    }
    
}
