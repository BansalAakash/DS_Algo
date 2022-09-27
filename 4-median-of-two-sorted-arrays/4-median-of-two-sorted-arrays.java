class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length, n = n1 + n2;
        if(n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        int cut1 = 0, cut2 = 0, l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        int x = n % 2 == 0 ? n / 2 : n / 2 + 1;
        int low = 0, high = Math.min(n1, x);
        while(low <= high){
            cut1 = low + (high - low) / 2;
            l1 = cut1 > 0 ? nums1[cut1 - 1] : Integer.MIN_VALUE;
            r1 = cut1 < n1 ? nums1[cut1] : Integer.MAX_VALUE;
            
            cut2 = x - cut1;
            l2 = cut2 > 0 ? nums2[cut2 - 1] : Integer.MIN_VALUE;
            r2 = cut2 < n2 ? nums2[cut2] : Integer.MAX_VALUE;
            
            if(l1 <= r2 && l2 <= r1)
                break;
            if(l1 > r2)
                high = cut1 - 1;
            else low = cut1 + 1;
        }
        return n % 2 == 0 ? (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0 : Math.max(l1, l2);
    }
}