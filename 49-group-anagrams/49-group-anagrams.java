class Solution {
    String getHash(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray())
            freq[ch - 'a']++;
        return Arrays.toString(freq);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String hash = getHash(str);
            if(map.containsKey(hash))
                 map.get(hash).add(str);
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(hash, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}