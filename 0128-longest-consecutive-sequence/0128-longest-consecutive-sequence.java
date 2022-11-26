class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : nums)
            set.add(i);
        int max = 0;
        for(int i : nums){
            if(!set.contains(i - 1)){
                int j = i + 1, cur = 1;
                while(set.contains(j)){
                    cur++;
                    j++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}