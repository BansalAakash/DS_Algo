class Solution {
    void helper(List<List<Integer>> result, List<Integer> cur, int index, int[] nums, boolean[] taken){
        if(index == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!taken[i]){
                taken[i] = true;
                cur.add(nums[i]);
                helper(result, cur, index + 1, nums, taken);
                cur.remove(cur.size() - 1);
                taken[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 0, nums, new boolean[nums.length]);
        return result;
    }
}