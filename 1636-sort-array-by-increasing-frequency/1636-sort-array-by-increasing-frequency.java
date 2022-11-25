class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Integer[] nums2 = Arrays.stream(nums).boxed().sorted((a, b) -> map.get(a) == map.get(b) ? b - a : map.get(a) - map.get(b)).toArray(Integer[] :: new);
        nums = Stream.of(nums2).mapToInt(Integer::intValue).toArray();
        return nums;
    }
}