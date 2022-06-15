class MinStack {
    long min;
    Stack<Long> stack;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int a) {
        long val = Long.valueOf(a);
        if(stack.isEmpty()){
            min = val;
            stack.push(min);
        } else if(val >= min){
            stack.push(val);
        } else {
            stack.push(2 * val - min);
            min = val;
        }
    }
    
    public void pop() {
        long temp = stack.pop();
        if(temp < min)
            min = 2 * min - temp;
    }
    
    public int top() {
        long temp = stack.peek() >= min ? stack.peek() : min;
        return (int) temp;
    }
    
    public int getMin() {
        return (int) min;
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