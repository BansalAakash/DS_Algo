class Solution {
    void solve(String digits, List<String> result, StringBuilder s, int i, int n, HashMap<Character, char[]> map){
        if(i == n){
            result.add(new String(s));
            return;
        }
        for(char ch : map.get(digits.charAt(i))){
            s.append(ch);
            solve(digits, result, s, i + 1, n, map);
            s.deleteCharAt(s.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int n = digits.length();
        if(n == 0)
            return result;
        HashMap<Character, char[]> map = new HashMap<>();
        map.put('2', new char[] {'a', 'b', 'c'});
        map.put('3', new char[] {'d', 'e', 'f'});
        map.put('4', new char[] {'g', 'h', 'i'});
        map.put('5', new char[] {'j', 'k', 'l'});
        map.put('6', new char[] {'m', 'n', 'o'});
        map.put('7', new char[] {'p', 'q', 'r', 's'});
        map.put('8', new char[] {'t', 'u', 'v'});
        map.put('9', new char[] {'w', 'x', 'y', 'z'});
        solve(digits, result, new StringBuilder(), 0, n, map);
        return result;
    }
}