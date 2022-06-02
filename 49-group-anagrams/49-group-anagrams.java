class Solution {
    int returnHash(String str){
        int[] freq = new int[26];
        for(char ch : str.toCharArray())
            freq[ch - 'a']++;
        return Arrays.hashCode(freq);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(String str : strs){
            int hash = returnHash(str);
            // System.out.println(str + " " + hash);
            if(map.containsKey(hash))
                result.get(map.get(hash)).add(str);
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map.put(hash, result.size() - 1);
            }
        }
        return result;
    }
}