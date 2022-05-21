class Solution {
    void helper(List<String> result, char[] str, int index){
        if(index == str.length)
            result.add(new String(str));
        else if(str[index] >= '0' && str[index] <= '9')
            helper(result, str, index + 1);
        else{
            helper(result, str, index + 1);
            if(str[index] >= 97){
                str[index] -= 32;
                helper(result, str, index + 1);
                str[index] += 32;
            } else{
                str[index] += 32;
                helper(result, str, index + 1);
                str[index] -= 32;
            }
        }
    }
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s.toCharArray(), 0);
        return result;
    }
}