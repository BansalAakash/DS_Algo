import java.util.*;
class Solution {
    boolean isPalindrom(String s, int i, int j){
        while(i < j)
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
    int f(String s, int start, int n, int[] dp){
        if(start == n)
            return 0;
        if(dp[start] != -1)
            return dp[start];
        int cuts = Integer.MAX_VALUE;
        for(int j = start;j < n;j++)
            if(isPalindrom(s, start, j))
                cuts = Math.min(cuts, 1 + f(s, j + 1, n, dp));
        return dp[start] = cuts;
    }
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        for(int i = n - 1; i >= 0;i--){
            int cuts = Integer.MAX_VALUE;
            for(int j = i;j < n;j++){
                if(isPalindrom(s, i, j))
                    cuts = Math.min(cuts, 1 + dp[j + 1]);
            }
            dp[i] = cuts;
        }
        return dp[0] - 1;
    }
}