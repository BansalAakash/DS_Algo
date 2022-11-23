class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        HashMap<Integer, Integer> leftMap = new HashMap<>(), rightMap = new HashMap<>();
        for(int k = 0;k <= j;k++){
            leftMap.put(nums[k], k);
            rightMap.put(nums[j - k], j - k);
        }
        
        Arrays.sort(nums);
        while(i < j){
            int temp = nums[i] + nums[j];
            if(temp < target)
                i++;
            else if(temp > target)
                j--;
            else return new int[] {leftMap.get(nums[i]), rightMap.get(nums[j])};
        }
        return null;
    }
}