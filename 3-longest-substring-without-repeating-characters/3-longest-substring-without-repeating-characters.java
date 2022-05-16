class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, max = 0;
        while(j < s.length()){
            if(map.containsKey(s.charAt(j)))
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            map.put(s.charAt(j), j);
            max =  Math.max(max, (j - i) + 1);
            j++;
        }
        return max;
    }
}