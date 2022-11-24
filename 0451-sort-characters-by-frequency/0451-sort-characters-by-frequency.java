//digits...upper...lower
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> cur = pq.poll();
            int count = cur.getValue();
            char ch = cur.getKey();
            while(count-- > 0)
                str.append(ch);
        }
        return str.toString();
    }
}