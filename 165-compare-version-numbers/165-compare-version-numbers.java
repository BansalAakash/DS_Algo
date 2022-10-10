class Solution {
    int compareStrings(String str1, String str2){
        // System.out.println(str1 + ", " + str2);
        int i = 0, j = 0, m = str1.length(), n = str2.length();
        
        while(i < m && str1.charAt(i) == '0')
            i++;
        
        while(j < n && str2.charAt(j) == '0')
            j++;
        
        int v1 = 0, v2 = 0;
        for(int x = m - 1;x >= i;x--)
            v1 = v1 * 10 + str1.charAt(x);
        
        for(int y = n - 1;y >= j;y--)
            v2 = v2 * 10 + str2.charAt(y);
        
        return v1 == v2 ? 0 : (v1 < v2 ? -1 : 1);
    }
    public int compareVersion(String version1, String version2) {
        
        String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
        int m = v1.length, n = v2.length, i = 0, j = 0;
        while(i < m || j < n){
            String s1 = i < m ? v1[i] : "";
            String s2 = j < n ? v2[j] : "";
            int result = compareStrings(s1, s2);
            if(result != 0)
                return result;
            i++;
            j++;
        }
        return 0;
    }
}