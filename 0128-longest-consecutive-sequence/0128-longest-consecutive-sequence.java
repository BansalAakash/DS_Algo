class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length, max = 0;
        for(int i = 0;i < n;i++)
            map.put(nums[i], i);
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                int j = i, cur = 1;
                visited[j] = true;
                while(map.containsKey(nums[j] - 1)){
                    visited[j] = true;
                    j = map.get(nums[j] - 1);
                    cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}