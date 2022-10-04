class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        for(int i = 0;i < n;i++){
            while(!dq.isEmpty() && dq.getFirst() < i - k + 1)               //remove expired elems from front
                dq.removeFirst();
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i])                  //remove small elems from rear
                dq.removeLast();
            dq.addLast(i);
            if(i >= k - 1)
                result[i - k + 1] = nums[dq.getFirst()];
        }
        return result;
    }
}