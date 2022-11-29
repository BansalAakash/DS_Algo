class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        while(i < n - 3){
            int j = i + 1;
            if(nums[i] > target / 4 || nums[n - 1] < target / 4)
                return result;
            while(j < n - 2){
                int k = j + 1, l = n - 1;
                while(k < l){
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do{
                            k++;
                        } while(k < l && nums[k] == nums[k - 1]);
                        do{
                            l--;
                        } while(k < l && nums[l] == nums[l + 1]);
                    } else if(sum < target){
                        k++;
                    } else l--;
                }
                do{
                    j++;
                } while(j < n - 2 && nums[j] == nums[j - 1]);
            }
            do{
                    i++;
                } while(i < n - 3 && nums[i] == nums[i - 1]);
        }
        return result;
    }
}