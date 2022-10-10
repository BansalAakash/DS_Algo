class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char ch : s.toCharArray())
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        
        for(char ch : t.toCharArray()){
            if(freq.getOrDefault(ch, 0) == 0)
                return false;
            freq.put(ch, freq.get(ch) - 1);
        }
        for(char ch : freq.keySet())
            if(freq.get(ch) != 0)
                return false;
        return true;
    }
}