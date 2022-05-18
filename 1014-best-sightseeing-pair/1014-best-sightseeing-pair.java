class Solution {
   public int maxScoreSightseeingPair(int[] values) {
        int maxEndRight = values[values.length - 1] - (values.length - 1), maxScore = Integer.MIN_VALUE;
        for(int i = values.length - 2;i >= 0;i--){
            maxScore = Math.max(maxScore, values[i] + i + maxEndRight);
            maxEndRight = Math.max(maxEndRight, values[i] - i);
        }
        return maxScore;
    }
}