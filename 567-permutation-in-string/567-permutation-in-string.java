class Solution {
    boolean isEqual(int[] arr1, int[] arr2){
        for(int i = 0;i < arr1.length;i++)
            if(arr1[i] != arr2[i]) return false;
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] s1_map = new int[26];
        int[] s2_map = new int[26];
        for(int i : s1.toCharArray())
            s1_map[i - 97]++;
        for(int i = 0;i < s1.length();i++)
            s2_map[s2.charAt(i) - 97]++;
        if(isEqual(s1_map, s2_map)) return true;
        for(int i = s1.length();i < s2.length();i++){
            s2_map[s2.charAt(i) - 97]++;
            s2_map[s2.charAt(i - s1.length()) - 97]--;
            if(isEqual(s1_map, s2_map)) return true;
        }
        return false;
    }
}