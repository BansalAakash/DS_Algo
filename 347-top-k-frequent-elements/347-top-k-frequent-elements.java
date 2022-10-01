class Node implements Comparable<Node>{
    int val, freq;
    public Node(int a, int b){
        val = a;
        freq = b;
    }
    @Override
    public int compareTo(Node n){
        return this.freq - n.freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i : nums)                                                            //O(n) time
            if(freq.containsKey(i))
                freq.put(i, freq.get(i) + 1);
            else freq.put(i, 1);
        PriorityQueue<Node> pq = new PriorityQueue<>();                             //O(k) space
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));                     //O(k logk) time
            if(pq.size() > k)
                pq.poll();
        }
        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty())                                                            //O(k) time
            result[i++] = pq.poll().val;
        return result;
    }
}