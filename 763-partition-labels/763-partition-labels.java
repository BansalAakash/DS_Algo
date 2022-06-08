class Solution {
    void display(List<int[]> list){
        for(int[] arr: list)
            System.out.println(arr[0] + ", " + arr[1]);
    }
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> index = new HashMap<>();
        List<int[]> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            char ch = s.charAt(i);
            if(index.containsKey(ch)){
                list.get(index.get(ch))[1] = i;
            } else{
                index.put(ch, list.size());
                list.add(new int[] {i, i});
            }
        }
        int start = list.get(0)[0], end = list.get(0)[1];
        for(int i = 1;i < list.size();i++){
            if(list.get(i)[0] < end)
                end = Math.max(end, list.get(i)[1]);
            else{
                result.add(end - start + 1);
                start = list.get(i)[0];
                end = list.get(i)[1];
            }
        }
        result.add(end - start + 1);
        return result;
    }
}