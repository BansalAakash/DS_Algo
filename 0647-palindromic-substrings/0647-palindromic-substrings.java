class Solution {
    private int count(String s, int i, int j, int n){
        int ans = 0;
        while(i >= 0 && j <= n - 1){
            if(s.charAt(i) == s.charAt(j))
                ans++;
            else return ans;
            i--;
            j++;
        }
        return ans;
    }
    public int countSubstrings(String s) {
        int n = s.length(), result = 0;
        for(int i = 0;i < n;i++)
            result += count(s, i, i, n) + count(s, i, i + 1, n);
        return result;
    }
}