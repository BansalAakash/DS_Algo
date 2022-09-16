class Solution {
    void helper(List<List<String>> result, ArrayList<String> list, String s, int start, boolean[][] dp){
        if(start == s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int end = start; end < s.length();end++){
            if(s.charAt(start) == s.charAt(end) && ((end - start) <= 2 || dp[start + 1][end - 1])){
                dp[start][end] = true;
                list.add(s.substring(start, end + 1));
                helper(result, list, s, end + 1, dp);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        helper(result, new ArrayList<String>(), s, 0, new boolean[n + 1][n + 1]);
        return result;
    }
}