class Solution {
    void solve(List<String> result, StringBuilder s, int open, int close){
        if(close == 0){
            result.add(new String(s));
            return;
        }
        if(open > 0){
            s.append('(');
            solve(result, s, open - 1, close);
            s.deleteCharAt(s.length() - 1);
        }
        if(open < close){
            s.append(')');
            solve(result, s, open, close - 1);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(result, new StringBuilder(), n, n);
        return result;
    }
}