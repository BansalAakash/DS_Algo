class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        int n = nums.length;
        for(int i = 0;i < n;i++)
            count[nums[i]]++;
        int i = 0, j = 0;
        while(i < n){
            while(count[j] == 0)j++;
            nums[i++] = j;
            count[j]--;
        }
    }
}