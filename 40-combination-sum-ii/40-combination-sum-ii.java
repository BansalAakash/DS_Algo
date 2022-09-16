class Solution {
    void helper(List<List<Integer>> result, List<Integer> list, int val, int[] nums, boolean[] taken, int start){
        if(val == 0) result.add(new ArrayList<>(list));
        if(val <= 0) return;
        for(int i = start;i < nums.length;i++){
            if(!taken[i] && (i == start || nums[i] != nums[i - 1])){
                taken[i] = true;
                list.add(nums[i]);
                helper(result, list, val - nums[i], nums, taken, i + 1);
                taken[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), target, nums, new boolean[nums.length], 0);
        return result;
    }
}