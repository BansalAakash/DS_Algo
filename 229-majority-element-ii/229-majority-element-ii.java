class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if(n == 1){
            result.add(nums[0]);
            return result;
        }
        int elem1 = Integer.MIN_VALUE, elem2 = Integer.MIN_VALUE, count1 = 0, count2 = 0;
        for(int i : nums){
            if(i == elem1){
                count1++;
            } else if(i == elem2){
                count2++;
            } else if(count1 == 0){
                count1 = 1;
                elem1 = i;
            } else if(count2 == 0){
                count2 = 1;
                elem2 = i;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i : nums){
            if(i == elem1)
                count1++;
            else if (i == elem2)
                count2++;
        }
        if(count1 > n / 3)
            result.add(elem1);
        if(count2 > n / 3)
            result.add(elem2);
        return result;
    }
}