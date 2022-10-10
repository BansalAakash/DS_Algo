class Solution{
    int[] lps(StringBuilder s){
        int i = 1, j = 0, n = s.length();
        int[] lps = new int[n];
        while(i < n){
            while(i < n && s.charAt(i) == s.charAt(j)){
                lps[i] = j + 1;
                i++;
                j++;
            }
            if(j == 0)
                i++;
            else
                j = lps[j - 1];
        }
        return lps;
    }
	public String shortestPalindrome(String s) {
        int i = 0, n = s.length();
        StringBuilder rev = new StringBuilder(s).reverse();
        rev.insert(0, "$");
        rev.insert(0, s);
        int n1 = rev.length();
        int[] lps = lps(rev);
        return rev.substring(n + 1, n1 - lps[n1 - 1]) + s;
    }
}