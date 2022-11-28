class Solution {
    public List<Integer> getRow(int n) {
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for(int i = 1;i <= n;i++){
            int prev = cur.get(0);
            for(int j = 1;j < i;j++){
                int temp = cur.get(j);
                cur.set(j, prev + cur.get(j));
                prev = temp;
            }
            cur.add(1);
        }
        return cur;
    }
}