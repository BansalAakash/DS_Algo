class Solution {
    public int countPrimes(int n) {
        if(n < 2)
            return 0;
        boolean[] dp = new boolean[n];
        int count = 0;
        for(int i = 2;i < n;i++)
            if(!dp[i]){
                count++;
                for(int j = i + i;j < n; j += i)
                    dp[j] = true;
            }
        return count;
    }
}