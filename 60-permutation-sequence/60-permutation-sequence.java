class Solution {
    private String getPermutation(int n, int k, HashSet<Integer> set, StringBuilder string, int[] fact){
        int firstI = 1;
        for(firstI = 1;firstI <= 9;firstI++)
            if(!set.contains(firstI)) break;
        if(n == 1){
            string.append(firstI);
            return string.toString();
        }
        int i = firstI, temp = 0, count = -1;
        while(temp < k){
            if(!set.contains(i)){
                temp += fact[n - 1];
                count++;
            }
            i++;
        }
        set.add(i - 1);
        string.append(i - 1);
        return getPermutation(n - 1, k - count * fact[n - 1], set, string, fact);
    }
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1;i < n;i++) fact[i] = i * fact[i - 1];
        return getPermutation(n, k, new HashSet<>(), new StringBuilder(), fact);
    }
}