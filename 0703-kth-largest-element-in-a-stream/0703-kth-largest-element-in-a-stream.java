class KthLargest {

    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        q = new PriorityQueue<>();
        this.k = k;
        for(int i : nums)
            addhelper(i);
    }
    
    public int add(int val) {
        addhelper(val);
        return q.peek();
    }
    
    private void addhelper(int val){
        q.add(val);
        if(q.size() > k)
            q.poll();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */