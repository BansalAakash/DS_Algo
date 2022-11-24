class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            if((i & 1) == 1)
                continue;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int count = 0, result = Integer.MAX_VALUE;
        for(int i : map.keySet()){
            if(map.get(i) == count && i < result)
                result = i;
            else if(map.get(i) > count){
                count = map.get(i);
                result = i;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}