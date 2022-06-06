class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = nums[0], count = prefixSum == k ? 1 : 0, n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        for(int i = 1;i < n;i++){
            prefixSum += nums[i];
            if(prefixSum == k) count++;
            if(map.containsKey(prefixSum - k))
                count += map.get(prefixSum - k);
            map.putIfAbsent(prefixSum, 0);
            map.put(prefixSum, map.get(prefixSum) + 1);
        }
        return count;
    }
}