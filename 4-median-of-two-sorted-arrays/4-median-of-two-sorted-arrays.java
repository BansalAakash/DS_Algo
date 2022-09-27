class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length, n = n1 + n2, count = 0;
        int elem1 = 0, elem2 = 0;
        while(count++ <= n / 2){
            elem1 = elem2;
            if(i == n1){
                elem2 = nums2[j];
                j++;
            }
            else if(j == n2){
                elem2 = nums1[i];
                i++;
            }
            else if(nums1[i] < nums2[j]){
                elem2 = nums1[i];
                i++;
            }
            else{
                elem2 = nums2[j];
                j++;
            }
        }
        return n % 2 == 1 ? elem2 : (elem1 + elem2) / 2.0;
    }
}