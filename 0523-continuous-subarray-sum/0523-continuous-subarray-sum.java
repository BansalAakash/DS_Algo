class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, n = nums.length;
        for(int i = 0;i < n;i++) {
        	prefixSum += nums[i];
            if(i > 0 && prefixSum % k == 0)
                return true;
            if(map.containsKey(prefixSum % k) && i > map.get(prefixSum % k) + 1)
                return true;
            if(!map.containsKey(prefixSum % k))
        	    map.put(prefixSum % k, i);
        }
        return false;
    }
}