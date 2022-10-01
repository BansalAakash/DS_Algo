class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // System.out.println("*****");
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
            max = Math.max(max, map.get(i));
        }
        ArrayList<Integer>[] buckets = new ArrayList[max + 1];
        for(int key : map.keySet()){
            int val = map.get(key);
            if(buckets[val] == null)
                buckets[val] = new ArrayList<>();
            buckets[val].add(key);
        }
        int count = 0;
        // for(ArrayList<Integer> arr : buckets){
        //     System.out.print(count++ + " : ");
        //     if(arr != null){
        //         for(int i : arr)
        //             System.out.print(i + ", ");
        //     }
        //     System.out.println();
        // }
        
        int[] result = new int[k];
        int i = 0, j = max;
        while(i < k){
            if(buckets[j] != null)
                for(int x : buckets[j])
                    result[i++] = x;
            j--;
        }
        return result;
    }
}