class Solution {
    void permute(List<List<Integer>> result, ArrayList<Integer> cur, HashSet<Integer> set, int[] nums){
		if(set.size() == nums.length){
			result.add(new ArrayList<>(cur));
			return;
		}
		for(int i = 0;i < nums.length;i++){
			if(!set.contains(i)){
				cur.add(nums[i]);
				set.add(i);
				permute(result, cur, set, nums);
				cur.remove(cur.size() - 1);
				set.remove(i);
			}
		}
	}
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
		permute(result, new ArrayList<>(), new HashSet<>(), nums);
		return result;
    }
}