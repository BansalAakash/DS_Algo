class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> list = new ArrayList<>();
        int left = 0;
        while(n > 0){
            list.add(0, n % 10);
            n = n / 10;
            left++;
        }
        left -= 2;
        while(left >= 0 && list.get(left) >= list.get(left + 1))
            left--;
        // System.out.println("Left: " + left);
        if(left < 0) return -1;
        int min = Integer.MAX_VALUE, right = -1;
        for(int i = left + 1;i < list.size();i++){
            if(list.get(i) > list.get(left) && list.get(i) - list.get(left) <= min){
                min = list.get(i) - list.get(left);
                right = i;
            }
        }
        // System.out.println("Right: " + right);
        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
        int i = left + 1, j = list.size() - 1;
        // display(list);
        while(i < j){
            temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }
        long result = 0, multiplier = 1;
        for(i = list.size() - 1;i >= 0;i--){
            result += list.get(i) * multiplier;
            multiplier *= 10;
        }
        // display(list);
        return result <= Integer.MAX_VALUE ? (int)result : -1;
    }
    void display(List<Integer> list){
        for(int i : list)
            System.out.print(i + ", ");
        System.out.println();
    }
}