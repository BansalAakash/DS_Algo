class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        while(j >= 0 && i >= 0){
            if(t.charAt(j) == s.charAt(i))i--;
            j--;
        }
        if(i >= 0) return false;
        return true;
    }
}