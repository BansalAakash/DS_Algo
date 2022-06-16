class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int m = s.length(), n = p.length();
        if(m < n)
            return result;
        int[] p_ = new int[26];
        int[] s_ = new int[26];
        for(int i = 0;i < n - 1;i++){
            p_[p.charAt(i) - 'a']++;
            s_[s.charAt(i) - 'a']++;
        }
        p_[p.charAt(n - 1) - 'a']++;
        for(int i = 0;i <= m - n;i++){
            s_[s.charAt(i + n - 1) - 'a']++;
            if(Arrays.equals(p_, s_))
                result.add(i);
            s_[s.charAt(i) - 'a']--;
        }
        return result;
    }
}