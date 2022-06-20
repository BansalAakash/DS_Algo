class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, m = (int)Math.pow(2, n);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0;i < m;i++){
            List<Integer> list = new ArrayList<>();
            int count = 0;
            while(count < n){
                if((i >> count & 1) == 1)
                    list.add(nums[count]);
                count++;
            }
            result.add(list);
        }
        return result;
    }
}