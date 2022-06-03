class Solution {
    boolean isAnagram(int[] freq1, int[] freq2){
        for(int i = 0;i < 26;i++)
            if(freq1[i] != freq2[i]) return false;
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int p_n = p.length(), s_n = s.length();
        if(s_n < p_n) return result;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i = 0;i < p.length();i++){
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }
        if(isAnagram(freq1, freq2))
            result.add(0);
        for(int i = p_n;i < s_n;i++){
            freq2[s.charAt(i - p_n) - 'a']--;
            freq2[s.charAt(i) - 'a']++;
            if(isAnagram(freq1, freq2)) result.add(i - p_n + 1);
        }
        return result;
    }
}