class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(n < 3) return result;
        Arrays.sort(nums);
        for(int i = 0;i < n - 2;i++){
            if(i == 0 || nums[i] != nums[i - 1]){
                int start = i + 1, end = n - 1, sum = 0 - nums[i];
                while(start < end){
                    if(nums[start] + nums[end] == sum){
                        result.add(Arrays.asList(0 - sum, nums[start], nums[end]));
                        while(start < n - 1 && nums[start + 1] == nums[start]) start++;
                        start++;
                    } else if(nums[start] + nums[end] > sum){
                        while(end > i && nums[end - 1] == nums[end]) end--;
                        end--;
                    }else{
                        while(start < n - 1 && nums[start + 1] == nums[start]) start++;
                        start++;
                    }
                }
            }
        }
        return result;
    }
}