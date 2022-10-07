class Solution {
    public String longestCommonPrefix(String[] strs) {
        int in = 0, n = strs.length;
        Arrays.sort(strs);
        char ch = ' ';
        while(in < strs[0].length()){
            ch = strs[0].charAt(in);
            for(int i = 1;i < n;i++)
                if(in == strs[i].length() || strs[i].charAt(in) != ch)
                    return strs[0].substring(0, in);
            in++;
        }
        return strs[0];
    }
}