class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for(int i : nums)
            res ^= i;
        int temp = res, i = 0;
        while(temp != 0 && (temp & 1) != 1){
            i++;
            temp = temp >> 1;
        }
        int part1 = res, part2 = res;
        for(int j : nums){
            if((1 & (j >> i)) == 1)
                part1 ^= j;
            else part2 ^= j;
        }
        return new int[] {part1, part2};
    }
}