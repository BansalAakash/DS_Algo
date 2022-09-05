class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        result.add(temp);
        for(int i = 1;i < n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            for(int j = 0;j < i - 1;j++)
                list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            list.add(1);
            result.add(list);
        }
        return result;
    }
}