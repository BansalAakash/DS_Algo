class Solution {
    int getHash(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray())
            freq[ch - 'a']++;
        return Arrays.hashCode(freq);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        for(String str : strs){
            int hash = getHash(str);
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