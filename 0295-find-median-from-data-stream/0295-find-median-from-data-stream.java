class MedianFinder {
    PriorityQueue<Integer> smallQ, largeQ;
    int size;
    public MedianFinder() {
        smallQ = new PriorityQueue<>((a, b) -> b - a);                              //stores smaller elements in max queue
        largeQ = new PriorityQueue<>();                                           //stores bigger elements in min queue
    }
    
    public void addNum(int num) {
        if(size % 2 == 0)
            pushToLarge(num);
        else 
            pushToSmall(num);
        size++;
    }
    
    public double findMedian() {
        if(size % 2 == 0)
            return (smallQ.peek() + largeQ.peek()) / 2.0;
        return largeQ.peek();
    }

    void pushToLarge(int num){
        smallQ.add(num);
        largeQ.add(smallQ.poll());
    }

    void pushToSmall(int num){
        largeQ.add(num);
        smallQ.add(largeQ.poll());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */