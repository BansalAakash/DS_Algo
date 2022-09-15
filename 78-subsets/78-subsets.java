class Solution {
    public void helper(int n, int cur, int[] nums, List<Integer> list, List<List<Integer>> result){
        if(cur == n){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        helper(n, cur + 1, nums, list, result);
        list.remove(list.size() - 1);
        helper(n, cur + 1, nums, list, result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums.length, 0, nums, new ArrayList<>(), result);
        return result;
    }
}