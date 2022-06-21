class Solution {
    void solve(int[] nums, List<List<Integer>> result, List<Integer> list, int sum, int target, int start){
        if(sum > target)
            return;
        if(sum == target){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            solve(nums, result, list, sum + nums[i], target, i);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, result, new ArrayList<>(), 0, target, 0);
        return result;
    }
}