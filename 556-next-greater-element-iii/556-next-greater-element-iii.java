import java.util.*;

class Solution {
    public int nextGreaterElement(int n) {
        // System.out.println("n is " + n);
        List<Integer> list = new ArrayList<>();
        int temp = n;
        while(temp != 0){
            list.add(0, temp % 10);
            temp = temp / 10;
        }
        // System.out.println("initally, list is " + list.toString());
        int i = list.size() - 2;
        for(;i >= 0;i--){
            if(list.get(i) < list.get(i + 1))
                break;
        }
        if(i == -1) return -1;
        int j = list.size() - 1, dif = Integer.MAX_VALUE, jIndex = -1, iIndex = i;
        while(j > i){
            if(list.get(j) > list.get(i) && list.get(j) - list.get(i) < dif){
                dif = list.get(j) - list.get(i);
                jIndex = j;
            }
            j--;
        }

        //swap i and j index
        swap(list, iIndex, jIndex);
        // System.out.println("after swapping, list is " + list.toString());
        //reverse everything to the right of iIndex
        int start = iIndex + 1, end = list.size() - 1;
        while(start < end){
            swap(list, start, end);
            start++;end--;
        }
        // System.out.println("after reversing, list is " + list.toString());
        long result = 0;
        for(int k = 0;k < list.size();k++)
            result = result * 10 + list.get(k);
        return result <= Integer.MAX_VALUE ? (int)result : -1;
    }
    void swap(List<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}