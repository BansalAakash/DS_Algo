class MyQueue {
    Stack<Integer> pushStack, popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    
    public void push(int x) {
        pushStack.push(x);
    }
    void move(){
        while(!pushStack.isEmpty())
            popStack.push(pushStack.pop());
    }
    public int pop() {
        if(popStack.isEmpty())
            move();
        return popStack.pop();
    }
    
    public int peek() {
        if(popStack.isEmpty())
            move();
        return popStack.peek();
    }
    
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */