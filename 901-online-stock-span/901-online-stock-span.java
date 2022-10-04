class StockSpanner {
    class Node{
        int price, span;
        public Node(int price){
            this.price = price;
            this.span = 1;
        }
    }
    Stack<Node> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }
    public int next(int price) {
        Node node = new Node(price);
        while(!stack.isEmpty() && stack.peek().price <= price){
            node.span += stack.peek().span;
            stack.pop();
        }
        stack.push(node);
        return node.span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */