class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(i < n - 2){
            int j = i + 1, k = n - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    do{
                        j++;
                    } while(j < k && nums[j] == nums[j - 1]);
                    do{
                        k--;
                    } while(j < k && nums[k] == nums[k + 1]);
                }
                else if(sum < 0)
                    j++;
                else k--;
            }
            do{
                i++;
            } while(i < n && nums[i] == nums[i - 1]);
        }
        return result;
    }
}