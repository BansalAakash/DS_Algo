class MinStack {
    Stack<Integer> s, min;
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(min.isEmpty() || val <= min.peek().intValue()){
            min.push(val);
        }
    }
    
    public void pop() {
        if(s.isEmpty())
            return;
        if(s.pop().intValue() == min.peek().intValue())
            min.pop();
    }
    
    public int top() {
        return s.isEmpty() ? Integer.MIN_VALUE : s.peek();
    }
    
    public int getMin() {
        return min.isEmpty() ? Integer.MIN_VALUE : min.peek();
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