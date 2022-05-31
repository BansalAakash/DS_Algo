class Solution {
    Boolean isAP(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        if(n < 3) return true;
        int dif = nums[1] - nums[0];
        for(int i = 2;i < n;i++)
            if(nums[i] - nums[i - 1] != dif) return false;
        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> result = new ArrayList<>(n);
        for(int i = 0;i < n;i++)
            result.add(isAP(Arrays.copyOfRange(nums, l[i], r[i] + 1)));
        return result;
    }
}