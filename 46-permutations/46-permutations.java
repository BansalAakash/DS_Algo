class Solution {
    void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    void helper(int index, List<Integer> list, List<List<Integer>> result) {
        if(index == list.size() - 1){
            result.add(List.copyOf(list));
            return;
        }
        for(int i = index;i < list.size();i++){
            swap(list, index, i);
            helper(index + 1, list, result);    
            swap(list, index, i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums) list.add(i);
        helper(0, list, result);
        return result;
    }
}