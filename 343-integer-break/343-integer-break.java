class Solution {
    public int integerBreak(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        int prev1 = 3, prev2 = 2, cur = 4, result = -1;
        for(int i = 5;i <= n;i++){
            result = Math.max(prev1 * 2, prev2 * 3);
            prev2 = prev1;
            prev1 = cur;
            cur = result;
        }
        return result;
    }
}