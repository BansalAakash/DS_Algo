class Solution {
    public int climbStairs(int n) {
        if(n < 3) return n;
        int prev1 = 2, prev2 = 1;
        n -= 2;
        while(n > 0){
            int temp = prev1;
            prev1 = prev1 + prev2;
            prev2 = temp;
            n--;
        }
        return prev1;
    }
}