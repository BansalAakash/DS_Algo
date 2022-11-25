class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int n = nums.length, index = 0;
        int[] result = new int[n - k + 1];
        
        for(int i = 0;i < n;i++){
            if(i >= k && dq.getFirst() == i - k)
                dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()] <= nums[i])
                dq.removeLast();
            dq.addLast(i);
            if(i >= k - 1)
                result[index++] = nums[dq.getFirst()];
        }
        return result;
    }
}