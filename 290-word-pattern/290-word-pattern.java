class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(str.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<>();
        // HashSet<String> set = new HashSet<>();
        for(int i = 0;i < pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch) && !map.get(ch).equals(str[i]))
                return false;
            if(!map.containsKey(ch) && map.containsValue(str[i]))
                return false;
            map.putIfAbsent(ch, str[i]);
            // set.add(str[i]);
        }
        return true;
    }
}