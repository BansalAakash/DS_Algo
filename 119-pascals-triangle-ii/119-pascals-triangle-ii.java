class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> list = new ArrayList<>(rowIndex + 1);
        for(int i = 0;i <= rowIndex;i++){
            list.add(0, 1);
            for(int j = 1;j < i;j++){
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }
}