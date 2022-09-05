class Solution {
    public void nextPermutation(int[] nums) {
        int ind1 = -1, ind2 = -1;
        for(int i = nums.length - 1;i > 0;i--){ //Step 1: Traverse right to left and find the first i such that A[i] < A[i + 1]
            if(nums[i - 1] < nums[i]){
                ind1 = i - 1;
                break;
            }
        }
        if(ind1 > -1){                                       //if ind == -1, that means the array is sorted in decreasing order, wo we skip this step
            for(int i = nums.length - 1;i > ind1;i--){       // Step 2: Traverse right to left and find the first j such that A[i] < A[j]
                if(nums[ind1] < nums[i]){
                    ind2 = i;
                    break;
                }
            }
            int temp = nums[ind1];                          //Step 3: Swap A[i] and A[j]
            nums[ind1] = nums[ind2];
            nums[ind2] = temp;
        }
        for(int i = ind1 + 1, j = nums.length - 1;i < j;i++,j--){         //Step 4: Reverse A[i + 1] to A[last]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
    }
}