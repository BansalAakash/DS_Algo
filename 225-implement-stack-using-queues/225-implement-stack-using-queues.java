class MyStack {
    Queue<Integer> curQ, otherQ;
    public MyStack() {
        curQ = new LinkedList<>();
        otherQ = new LinkedList<>();
    }
    
    public void push(int x) {
        otherQ.add(x);
        addAndSwap();
    }
    void addAndSwap(){
        while(!curQ.isEmpty())
            otherQ.add(curQ.poll());
        Queue<Integer> temp = curQ;
        curQ = otherQ;
        otherQ = temp;
    }
    public int pop() {
        return curQ.poll();
    }
    
    public int top() {
        return curQ.peek();
    }
    
    public boolean empty() {
        return curQ.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */