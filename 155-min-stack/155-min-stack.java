class MinStack {
    Stack<Long> s;
    Long min;
    public MinStack() {
        s = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int x) {
        Long val = Long.valueOf(x);
        if(s.isEmpty()){
            s.push(val);
            min = val;
        } else if(val.compareTo(min) < 0){
            s.push(2 * val - min);
            min = val;
        } else {
            s.push(val);
        }
    }
    
    public void pop() {
        Long temp = s.pop();
        if(temp.compareTo(min) < 0)
            min = 2 * min - temp;
    }
    
    public int top() {
        Long temp = s.peek();
        if(temp.compareTo(min) >= 0)
            return temp.intValue();
        return min.intValue();
    }
    
    public int getMin() {
        return min.intValue();
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