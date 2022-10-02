class MyStack {
    Queue<Integer> Q;
    int size;
    public MyStack() {
        Q = new LinkedList<>();
    }
    
    public void push(int x) {
        Q.add(x);
        size++;
        for(int i = 1;i < size;i++)
            Q.add(Q.poll());
    }
    public int pop() {
        return Q.poll();
    }
    
    public int top() {
        return Q.peek();
    }
    
    public boolean empty() {
        return Q.isEmpty();
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