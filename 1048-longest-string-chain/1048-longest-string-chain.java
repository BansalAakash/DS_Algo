class Solution {
    boolean compare(String str1, String str2){
        int i = 0, j = 0, n1 = str1.length(), n2 = str2.length();
        boolean flag = true;
        if(n2 - n1 != 1)
            return false;
        while(i < n1 && j < n2){
            if(str1.charAt(i) != str2.charAt(j)){
                if(flag == false)
                    return flag;
                flag = false;
            } else 
                i++;
            j++;
        }
        boolean result = i == n1 && (j == n2 || (j == n2 - 1 && flag));
        return result;
    }
    public int longestStrChain(String[] words) {
        int n = words.length, max = 0, lastIndex = -1;
        int[] dp = new int[n];
        // int[] parent = new int[n];
        // Arrays.fill(parent, -1);
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(int i = 0;i < n;i++){
            for(int j = i - 1;j >= 0;j--)
                if(compare(words[j], words[i]) && dp[i] <= dp[j]){
                    dp[i] = dp[j];
                    // parent[i] = j;
                }
            dp[i] += 1;
            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }
        // int i = lastIndex;
        // LinkedList<String> list = new LinkedList<>();
        // while(i != -1){
        //     list.addFirst(words[i]);
        //     i = parent[i];
        // }
        // System.out.println(list);
        return max;
    }
}