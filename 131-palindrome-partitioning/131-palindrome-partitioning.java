class Solution {
    boolean isPal(String s, int i, int j){ // index stores index of partition
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    void helper(List<List<String>> result, ArrayList<Integer> partitions, String s, int index){
        if(index == s.length()){
            if(partitions.size() > 0){
                int start = 0, end = -1;
                ArrayList<String> list = new ArrayList<>();
                for(int i = 0;i < partitions.size();i++){
                    end = partitions.get(i);
                    list.add(s.substring(start, end));
                    start = end;
                }
                result.add(list);
            }
            return;
        }
        for(int i = 1; i + index <= s.length();i++){
            if(isPal(s, index, index + i - 1)){
                partitions.add(index + i);
                helper(result, partitions, s, index + i);
                partitions.remove(partitions.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), s, 0);
        return result;
    }
}