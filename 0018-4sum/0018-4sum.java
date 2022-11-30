class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, 0, target, 4);
    }
    private List<List<Integer>> kSum(int[] nums, int start, long target, int k){
        int n = nums.length;
        long avg = target / k;
        List<List<Integer>> result = new ArrayList<>();
        if(start > n - k || nums[start] > avg || nums[n - 1] < avg)
            return result;
        if(k == 2)
            return twoSum(nums, start, target);
        for(int i = start;i < n;i++){
            if(i > start && nums[i] == nums[i - 1])
                continue;
            for(List<Integer> list : kSum(nums, i + 1, target - nums[i], k - 1)){
                List<Integer> cur = new ArrayList<>();
                cur.add(nums[i]);
                cur.addAll(list);
                result.add(cur);
            }
        }
        return result;
    }
    private List<List<Integer>> twoSum(int[] nums, int start, long target){
        int i = start, j = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                result.add(Arrays.asList(nums[i], nums[j]));
                do{
                    i++;
                } while(i < j && nums[i] == nums[i - 1]);
                do{
                    j--;
                } while(i < j && nums[j] == nums[j + 1]);
            } else if(sum > target)
                j--;
            else i++;
        }
        return result;
    }
}