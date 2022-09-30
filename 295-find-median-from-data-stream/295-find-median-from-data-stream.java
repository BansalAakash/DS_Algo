class MedianFinder {
    PriorityQueue<Integer> small, large;
    //All elems of small are <= all elems of large
    //small is max heap, large is min heap
    boolean even;
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(Collections.reverseOrder());
        even = true;
    }
    //no of elems in large = number of elems in small + 0/1
    //if current elems are even, next elem should go to large but not directly. To maintain ordering, we first put in small then transfer to large
    //vv for odd
    public void addNum(int num) {
        if(even){
            small.add(num);
            large.add(small.poll());
        } else {
            large.add(num);
            small.add(large.poll());
        }
        even = !even;
    }
    //if even elems, avg of top of large and small
    //if odd elems, top of large
    
    public double findMedian() {
        return even ? (small.peek() + large.peek()) / 2.0 : large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */