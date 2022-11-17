class Solution {
    public int maximumXOR(int[] nums) {
        int result = 0;
        for(int i : nums)
            result |= i;
        return result;
    }
}