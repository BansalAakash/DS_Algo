class Solution {
    public String countAndSay(int x) {
        if(x == 1)
            return "1";
        String result = countAndSay(x - 1);
        StringBuilder str = new StringBuilder();
        int cur = 1, i = 1, n = result.length();
        char ch = result.charAt(0);
        while(i <= n){
            while(i < n && result.charAt(i) == ch){
                i++;
                cur++;
            }
            str.append(cur);
            str.append(ch);
            cur = 1;
            if(i < n)
                ch = result.charAt(i);
            i++;
        }
        return str.toString();
    }
}