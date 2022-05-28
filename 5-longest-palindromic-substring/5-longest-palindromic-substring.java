class Solution {
    int helper(int start, int end, String str){
        int len = 0, n = str.length();
        while(start >= 0 && end < n && str.charAt(start) == str.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
    public String longestPalindrome(String s) {
        int len = 0, start = -1, end = -1, n = s.length();
        for(int i = 0;i < n;i++){
            int odd = helper(i, i, s);
            int even = helper(i, i + 1, s);
            int max = Math.max(odd, even);
            if(max > len){
                start = i - (max - 1) / 2;
                end = i + max / 2;
                len = end - start + 1;
            }
        }
        return s.substring(start, end + 1);
    }
}