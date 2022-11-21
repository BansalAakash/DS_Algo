class Solution {
    public int missingNumber(int[] nums) {
        int actual = 0, n = nums.length, expected = n * (n + 1) / 2;
        for(int i : nums)
            actual += i;
        return expected - actual;
    }
}