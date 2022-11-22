class Solution {
    public int subarraySum(int[] nums, int k) {
        int curSum = 0, n = nums.length, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            curSum += nums[i];
            if(curSum == k)
                count++;
            if(map.containsKey(curSum - k))
                count += map.get(curSum - k);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}