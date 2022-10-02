class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2)
            return nums;
        int result = 0;
        for(int i : nums)
            result ^= i;
        int i = 0;
        while((1 & (result >> i)) == 0)
            i++;
        int part1 = 0, part2 = 0;
        for(int j : nums){
            if((1 & (j >> i)) == 1)
                part1 ^= j;
            else part2 ^= j;
        }
        return new int[] {part1, part2};
    }
}