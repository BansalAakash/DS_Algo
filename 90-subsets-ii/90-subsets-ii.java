class Solution {
    void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int cur, boolean taken){
        if(cur == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        if(cur > 0 && nums[cur] == nums[cur - 1]){
            if(taken){
                list.add(nums[cur]);
                helper(result, list, nums, cur + 1, true);
                list.remove(list.size() - 1);
            }
        } else{
            list.add(nums[cur]);
            helper(result, list, nums, cur + 1, true);
            list.remove(list.size() - 1);
        }
        helper(result, list, nums, cur + 1, false);
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), nums, 0, false);
        return result;
    }
}