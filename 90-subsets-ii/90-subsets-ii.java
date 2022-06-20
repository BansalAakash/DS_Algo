class Solution {
    void solve(List<List<Integer>> result, List<Integer> list, int[] nums, int n, int i, boolean c){
        //c keeps track of whether we chose prev or not, c doesn't matter for i == 0
        if(i == n){
            result.add(new ArrayList<>(list));
            return;
        }
        if(i == 0 || nums[i] != nums[i - 1] || c == true){
            solve(result, list, nums, n, i + 1, false);
            list.add(nums[i]);
            solve(result, list, nums, n, i + 1, true);
            list.remove(list.size() - 1);    
        } else{ // this element is same as previous element, if we chose that, we'll choose this, and vv
            solve(result, list, nums, n, i + 1, false);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        solve(result, new ArrayList<>(), nums, nums.length, 0, false);
        return result;
    }
}