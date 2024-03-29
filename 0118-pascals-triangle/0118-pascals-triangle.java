class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        result.add(prev);
        for(int i = 1;i < n;i++){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for(int j = 1;j < i;j++)
                cur.add(prev.get(j - 1) + prev.get(j));
            cur.add(1);
            result.add(cur);
            prev = cur;
        }
        return result;
    }
}