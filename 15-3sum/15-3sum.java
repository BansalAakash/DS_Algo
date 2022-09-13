class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0, j = 1, k = n - 1;
        List<List<Integer>> result = new ArrayList<>();
        if(n < 3)
            return result;
        while(i < n - 2){
            j = i + 1;
            k = n - 1;
            while(j < k){
                if(nums[j] + nums[k] == -nums[i]){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j + 1] == nums[j]) j++;
                    while(j < k && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                }
                else if(nums[j] + nums[k] > -nums[i])
                    k--;
                else j++;
            }
            while(i < n - 2 && nums[i + 1] == nums[i]) i++;
            i++;
        }return result;
    }
}