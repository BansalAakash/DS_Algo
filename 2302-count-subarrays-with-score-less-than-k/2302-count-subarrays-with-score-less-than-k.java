class Solution {
    public long countSubarrays(int[] A, long k) {
        int left = 0, right = 0, n = A.length;
        long count = 0, score = 0;
        while(right < n){
            score = left == right ? A[right] : ((score / (right - left)) + A[right]) * (right - left + 1);
            while(score >= k){
                score = (score / (right - left + 1) - A[left]) * (right - left);
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}