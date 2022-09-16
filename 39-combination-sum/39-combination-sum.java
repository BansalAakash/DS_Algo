class Solution {
    void helper(List<List<Integer>> result, List<Integer> list, int val, int[] nums, int prev){
        if(val == 0) result.add(new ArrayList<>(list));
        if(val <= 0) return;
        
        for(int i : nums){
            if(i >= prev){
                list.add(i);
                helper(result, list, val - i, nums, i);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), target, nums, 0);
        return result;
    }
}