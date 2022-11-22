class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, n = nums.length;
        for(int i = 0;i < n;i++) {
        	prefixSum += nums[i];
                if(i > 0 && prefixSum % k == 0)
                    return true;
                for(int j = 0;j * k <= prefixSum;j++)
                    if(map.containsKey(prefixSum - j * k) && i - map.get(prefixSum - j * k) > 1)
                        return true;
            if(!map.containsKey(prefixSum))
        	    map.put(prefixSum, i);
        }
        return false;
    }
}