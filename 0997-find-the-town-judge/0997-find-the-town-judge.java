class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trusting = new HashMap<>();       //count of people I trusted
        Map<Integer, Set<Integer>> trusted = new HashMap<>();   //set of people that have trusted me
        
        for(int[] row : trust){
            int a = row[0], b = row[1];
            trusting.put(a, trusting.getOrDefault(a, 0) + 1);       //increasing the count of people a trusts
            trusted.putIfAbsent(b, new HashSet<>());
            trusted.get(b).add(a);  //b is trusted by a
        }
        for(int i = 1;i <= n;i++)
            if(!trusting.containsKey(i)  
                && trusted.getOrDefault(i, new HashSet<>()).size() == n - 1 
                && !trusted.getOrDefault(i, new HashSet<>()).contains(i))
                    return i;
        return -1;
    }
}