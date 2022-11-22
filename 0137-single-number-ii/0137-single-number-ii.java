class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0, sum = 0;
        for(int i = 0;i < 32;i++){
            sum = 0;
            for(int j : nums){
                if(((j >> i) & 1) == 1)
                    sum = (sum + 1) % 3;
            }
            if(sum != 0)
                ans = ans | (1 << i);
        }
        return ans;
    }
}