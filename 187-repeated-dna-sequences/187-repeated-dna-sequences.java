class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() <= 10) return new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        HashSet<String> resultSet = new HashSet<>();
        for(int i = 0;i <= s.length() - 10;i++){
            String temp = s.substring(i, i + 10);
            if(set.contains(temp)) resultSet.add(temp);
            set.add(temp);
        }
        return new ArrayList<>(resultSet);
    }
}