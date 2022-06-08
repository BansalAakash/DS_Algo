class SeatManager {
    PriorityQueue<Integer> q;       //contains unreserved seats
    public SeatManager(int n) {
        q = new PriorityQueue<>();
        q.add(1);
    }
    
    public int reserve() {
        if(q.size() == 1) q.add(q.peek() + 1);
        return q.poll();
    }
    
    public void unreserve(int seatNumber) {
        q.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */