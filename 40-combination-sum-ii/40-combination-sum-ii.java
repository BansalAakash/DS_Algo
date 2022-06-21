class Solution {
    void solve(int[] nums, List<List<Integer>> result, List<Integer> list, int sum, int target, int start){
        if(sum > target)
            return;
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            solve(nums, result, list, sum + nums[i], target, i + 1);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, result, new ArrayList<>(), 0, target, 0);
        return result;
    }
}