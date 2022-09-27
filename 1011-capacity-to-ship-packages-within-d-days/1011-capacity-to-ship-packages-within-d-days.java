class Solution {
    boolean feasible(int[] weights, int days, int m){
        int temp = 1, i = 0, cur = 0, n = weights.length;
        while(temp++ <= days){
            cur = 0;
            while(i < weights.length && cur + weights[i] <= m){
                cur += weights[i];
                i++;
            }
            if(i == weights.length) return true;
        }
        return temp <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int i : weights){
            max = Math.max(max, i);
            sum += i;
        }
        int low = max, high = sum, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(feasible(weights, days, mid)){
                high = mid;
                // System.out.println("Feasible with capacity " + mid);
            }
            else {
                low = mid + 1;
                // System.out.println("Not feasible with capacity " + mid);
            }
        }
        return low;
    }
}