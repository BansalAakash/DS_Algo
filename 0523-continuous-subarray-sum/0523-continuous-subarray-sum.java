class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, n = nums.length;
        map.put(0, 0);
        for(int i = 0;i < n;i++) {
        	prefixSum += nums[i];
            if(map.containsKey(prefixSum % k) && i > map.get(prefixSum % k))
                return true;
            if(!map.containsKey(prefixSum % k))
        	    map.put(prefixSum % k, i + 1);
        }
        return false;
    }
}