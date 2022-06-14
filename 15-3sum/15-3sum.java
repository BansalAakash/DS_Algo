class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int cur = 0, n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n < 3) return result;
        Arrays.sort(nums);
        while(cur < n - 2){
            int i = cur + 1, j = n - 1;
            while(i < j){
                int sum = nums[cur] + nums[i] + nums[j];
                if(sum == 0){
                    result.add(Arrays.asList(nums[cur], nums[i], nums[j]));
                    while(i < j && nums[j - 1] == nums[j])j--;
                    j--;
                    while(i < j && nums[i + 1] == nums[i])i++;
                    i++;
                }
                else if(sum > 0) {
                    while(i < j && nums[j - 1] == nums[j])j--;
                    j--;
                } else{
                    while(i < j && nums[i + 1] == nums[i])i++;
                    i++;
                }
            }
            while(cur < n - 2 && nums[cur + 1] == nums[cur]) cur++;
            cur++;
        }
        return result;
    }
}