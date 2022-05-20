class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) return false;
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        boolean[] dp = new boolean[s.length()];
        for(int i = 0;i < s.length();i++){
            for(int j = i + 1;j <= s.length();j++){
                String sub = s.substring(i, j);
                if(set.contains(sub) && (i == 0 || dp[i - 1])){
                    dp[j - 1] = true;
                    // break;
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }
}