class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>(rowIndex + 1);
        result.add(1);
        for(int i = 1;i <= rowIndex;i++){
            result.add(1);
            int temp = result.get(0);
            for(int j = 1;j < i;j++){
                int prev = result.get(j);
                result.set(j, temp + result.get(j));
                temp = prev;
            }
        }
        return result;
    }
}