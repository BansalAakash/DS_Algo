class Solution {
    void solve(List<List<Integer>> result, List<Integer> list, HashSet<Integer> taken, int[] nums){
        if(taken.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!taken.contains(i)){
                list.add(nums[i]);
                taken.add(i);
                solve(result, list, taken, nums);
                list.remove(list.size() - 1);
                taken.remove(i);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(result, new ArrayList<>(), new HashSet<>(), nums);
        return result;
    }
}