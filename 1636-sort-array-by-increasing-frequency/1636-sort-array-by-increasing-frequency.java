class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? b.getKey() - a.getKey() : a.getValue() - b.getValue()));
        pq.addAll(map.entrySet());
        int index = 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> e = pq.poll();
            int cur = e.getKey(), freq = e.getValue();
            while(freq-- > 0)
                nums[index++] = cur;
        }
        return nums;
    }
}