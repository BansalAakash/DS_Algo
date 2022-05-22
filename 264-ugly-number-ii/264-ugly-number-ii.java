class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet();
        set.add(1L);
        int i = 1;
        while(i < n){
            Long temp = set.pollFirst();
            set.add(temp * 2);
            set.add(temp * 3);
            set.add(temp * 5);
            i++;
        }
        return set.first().intValue();
    }
}