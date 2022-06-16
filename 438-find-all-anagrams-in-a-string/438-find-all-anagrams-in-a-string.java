class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int m = s.length(), n = p.length();
        if(m < n)
            return result;
        int[] p_ = new int[26];
        int[] s_ = new int[26];
        for(int i = 0;i < n;i++){
            p_[p.charAt(i) - 'a']++;
            s_[s.charAt(i) - 'a']++;
        }
        for(int i = 0;i < 26;i++)
            if(p_[i] != s_[i])
                set.add(i);
        if(set.isEmpty())
            result.add(0);
        
        for(int i = n;i < m;i++){
            s_[s.charAt(i) - 'a']++;
            s_[s.charAt(i - n) - 'a']--;
            
            if(s_[s.charAt(i) - 'a'] != p_[s.charAt(i) - 'a'])
                set.add(s.charAt(i) - 'a');
            else set.remove(s.charAt(i) - 'a');
            
            if(s_[s.charAt(i - n) - 'a'] != p_[s.charAt(i - n) - 'a'])
                set.add(s.charAt(i - n) - 'a');
            else set.remove(s.charAt(i - n) - 'a');
            
            if(set.isEmpty())
                result.add(i - n + 1);
        }
        return result;
    }
}