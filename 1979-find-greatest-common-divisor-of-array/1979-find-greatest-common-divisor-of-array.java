class Solution {
    int findGCD(int x, int y){
        if(x >= y && x % y == 0)
            return y;
        if(y > x && y % x == 0)
            return x;
        return findGCD(Math.abs(x - y), Math.min(x, y));
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