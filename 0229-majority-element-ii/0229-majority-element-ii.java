class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int elem1 = Integer.MAX_VALUE, elem2 = Integer.MAX_VALUE, count1 = 0, count2 = 0;
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
        int n = nums.length;
        for(int i : nums){
            if(i == elem1)
                count1++;
            else if(i == elem2)
                count2++;
        }
        List<Integer> result = new ArrayList<>();
        if(count1 > n / 3)
            result.add(elem1);
        if(count2 > n / 3)
            result.add(elem2);
        return result;
    }
}