class Solution {
    public String longestPalindrome(String s) {
        int len = 0, start = -1, end = -1, n = s.length();
        for(int i = 0;i < n;i++){
            // odd length
            int low = i, high = i;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > len){
                    len = high - low + 1;
                    start = low;
                    end = high;
                }
                low--;high++;
            }

            //even length
            low = i; high = i + 1;
            while(low >= 0 && high < n && s.charAt(low) == s.charAt(high)){
                if(high - low + 1 > len){
                    len = high - low + 1;
                    start = low;
                    end = high;
                }
                low--;high++;
            }
        }
        return s.substring(start, end + 1);
    }
}