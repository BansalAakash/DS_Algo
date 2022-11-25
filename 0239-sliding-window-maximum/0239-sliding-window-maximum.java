class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, index = 0;
        int[] result = new int[n - k + 1];
        
        for(int i = 0;i < n;i++){
            if(i >= k && map.get(dq.getFirst()) == i - k){
                map.remove(dq.getFirst());
                dq.removeFirst();
            }
            while(!dq.isEmpty() && dq.getLast() <= nums[i]){
                map.remove(dq.getLast());
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            map.put(nums[i], i);
            if(i >= k - 1)
                result[index++] = dq.getFirst();
        }
        return result;
    }
}