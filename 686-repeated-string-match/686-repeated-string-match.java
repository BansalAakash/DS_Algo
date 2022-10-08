class Solution {
    final int mod = (int)1e7+7, prime = 31;
    int hash(String str, int len){
        int result = 0;
        for(int i = 0;i < len;i++){
            result += ((str.charAt(i) - 'a' + 1) * Math.pow(prime, len - i - 1)) % mod;
            result %= mod;
        }
        return result;
    }
    int hash(StringBuilder str, int len){
        int result = 0;
        for(int i = 0;i < len;i++){
            result += ((str.charAt(i) - 'a' + 1) * Math.pow(prime, len - i - 1)) % mod;
            result %= mod;
        }
        return result;
    }
    boolean matches(StringBuilder str, String pat, int s_hash, int pat_hash){
        // System.out.println(str.toString() + ", " + pat);
        int n = pat.length();
        for(int i = n;i <= str.length();i++){
            if(s_hash == pat_hash && str.substring(i - n, i).toString().equals(pat))
                return true;
            if(i < str.length()){
                s_hash -= ((str.charAt(i - n) - 'a' + 1) * Math.pow(prime, n - 1)) % mod;
                s_hash *= prime;
                s_hash += str.charAt(i) - 'a' + 1;
                s_hash %= mod;
                if(s_hash < 0)
                    s_hash += mod;
            }
        }
        return false;
    }
    public int repeatedStringMatch(String str, String pat) {
        int count = 1;
        StringBuilder s = new StringBuilder(str);
        while(s.length() < pat.length()){
            s.append(str);
            count++;
        }
        int p_hash = hash(pat, pat.length()), s_hash = hash(s, pat.length()), initCount = count * 2;
        while(count <= initCount){
            if(matches(s, pat, s_hash, p_hash))
                return count;
            s.append(str);
            count++;
        }
        return -1;
    }
}