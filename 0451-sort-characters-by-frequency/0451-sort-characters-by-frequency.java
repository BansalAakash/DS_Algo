//digits...upper...lower
class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[62];
        int maxFreq = -1;
        for(char ch : s.toCharArray()){
            int i = 0;
            if(ch >= 'a')
                i = ch - 'a' + 36;
            else if(ch >= 'A')
                i = ch - 'A' + 10;
            else
                i = ch - '0';
            freq[i]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(int i = 0;i < 62;i++)
            pq.add(new int[] {i, freq[i]});
        StringBuilder str = new StringBuilder();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int ch = 0;
            if(cur[0] < 10)
                ch = cur[0] + '0';
            else if(cur[0] < 36)
                ch = cur[0] - 10 + 'A';
            else ch = cur[0] - 36 + 'a';
            int count = cur[1];
            while(count-- > 0)
                str.append((char)ch);
        }
        return str.toString();
    }
}