class Solution {
    boolean feasible(int[] piles, int h, int k){
        int total = 0;
        for(int pile : piles)
            total += pile % k == 0 ? pile / k : pile / k + 1;
        return total <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i : piles)
            max = Math.max(max, i);
        int low = 1, high = max, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(feasible(piles, h, mid))
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}