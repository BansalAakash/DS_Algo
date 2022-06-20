class Solution {
    void solve(List<List<Integer>> result, List<Integer> list, int[] nums, int i, int n){
        if(i == n){
            result.add(new ArrayList<>(list));
            return;
        }
        solve(result, list, nums, i + 1, n);
        list.add(nums[i]);
        solve(result, list, nums, i + 1, n);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, new ArrayList<>(), nums, 0, nums.length);
        return result;
    }
}