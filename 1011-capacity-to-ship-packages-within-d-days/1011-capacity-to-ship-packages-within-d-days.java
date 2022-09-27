class Solution {
    boolean feasible(int[] weights, int days, int m){
        int tempDays = 1, i = 0, cur = 0, n = weights.length;
        while(i < weights.length){
            if(cur + weights[i] > m){
                tempDays++;
                if(tempDays > days) return false;
                cur = weights[i];
            } else {
                cur += weights[i];
            }
            i++;
        }
        return true;
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