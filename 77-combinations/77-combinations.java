class Solution {
    boolean containsKSetBits(int n, int k){
        while(n != 0){
            k -= n & 1;
            n = n >> 1;
        }
        return k == 0;
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] values = new int[n];
        for(int i = 0;i < n;i++)
            values[i] = i + 1;
        for(int i = 0;i < Math.pow(2, n);i++){
            if(containsKSetBits(i, k)){
                List<Integer> list = new ArrayList();
                int temp = i,j = 0;
                while(temp != 0){
                    if((temp & 1) == 1)
                        list.add(values[j]);
                    temp = temp >> 1;
                    j++;
                }
                result.add(list);
            }
        }
        return result;
    }
}