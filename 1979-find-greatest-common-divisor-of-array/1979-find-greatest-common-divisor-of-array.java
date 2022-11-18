class Solution {
    int findGCD(int x, int y){
        if(x == 0)
            return y;
        return findGCD(y % x, x);
    }
    public int findGCD(int[] nums) {
        int min = 1001, max = 0;
        for(int i : nums){
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        return findGCD(min, max);
    }
}