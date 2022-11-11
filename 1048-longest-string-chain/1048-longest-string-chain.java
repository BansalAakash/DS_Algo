class Solution {
    boolean compare(String a, String b){
        if(b.length() - a.length() != 1)
            return false;
        int i = 0, j = 0, m = a.length(), n = b.length();
        boolean flag = false;
        while(i < m && j < n){
            if(a.charAt(i) != b.charAt(j)){
                if(flag == false){
                    flag = true;
                } else return false;
            } else
                i++;
            j++;
        }
        if(i == m && j >= n - 1)
            return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        int n = words.length, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(compare(words[j], words[i]) && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}