class Solution {
    int helper(int i, int j, String s){
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return j - i - 1;
    }
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int maxLen = 0, curLen = 0;
        String result = "";
        for(int i = 0;i < s.length();i++){
            curLen = Math.max(helper(i, i, s), helper(i, i + 1, s));
            if(curLen > maxLen){
                result = s.substring(i - (curLen - 1) / 2, i + curLen / 2 + 1);
                maxLen = curLen;
            }
        }
        return result;
    }
}