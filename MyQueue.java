// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        this.inStack = new Stack<>();
        this.outStack = new Stack<>();
    }

    public void push(int x) {

        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();

    }

    public int peek() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            return -1;
        }
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            return outStack.peek();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return (inStack.isEmpty() && outStack.isEmpty());
    }
}