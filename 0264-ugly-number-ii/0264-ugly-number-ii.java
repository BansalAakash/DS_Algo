class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        int i = 1;
        while(i < n){
            Long x = set.pollFirst();
            set.add(x * 2);
            set.add(x * 3);
            set.add(x * 5);
            i++;
        }
        return set.pollFirst().intValue();
    }
}