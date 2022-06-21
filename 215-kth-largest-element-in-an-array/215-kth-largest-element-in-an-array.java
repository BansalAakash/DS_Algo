class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i : nums){
            pq.add(i);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }
}