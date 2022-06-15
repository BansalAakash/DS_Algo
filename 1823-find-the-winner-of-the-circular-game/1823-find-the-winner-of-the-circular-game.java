class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1;i <= n;i++)
            list.add(i);
        int i = 0;
        while(list.size() > 1){
            int j = (i + k - 1) % list.size();
            // System.out.println("Removing " + list.get(j) + " at index " + j);
            list.remove(j);
            i = j;
        }
        return list.get(0);
    }
}