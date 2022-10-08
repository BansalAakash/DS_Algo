class Solution{
	final int mod = (int)1e7+7, p = 31;
	int hash(String str, int end){
		int hash = 0;
        for(int i = end;i >= 0;i--){
        	hash += ((str.charAt(i) - 'a' + 1) * Math.pow(p, end - i)) % mod;
        	hash %= mod;
        }
        return hash;
	}
	public int strStr(String str, String pat) {
        if(pat.length() > str.length())
            return -1;
        int pat_hash = hash(pat, pat.length() - 1), str_hash = hash(str, pat.length() - 1);
        // System.out.println("Hash of pattern " + pat + " is " + pat_hash);
        for(int i = pat.length();i <= str.length();i++){
        	// System.out.println("Hash of " + str.substring(i - pat.length(), i) + " is " + str_hash);
        	if(pat_hash == str_hash && str.substring(i - pat.length(), i).equals(pat))
        		return i - pat.length();
        	if(i < str.length()){
	        	str_hash -= (str.charAt(i - pat.length()) - 'a' + 1) * (Math.pow(p, pat.length() - 1) % mod);
	        	str_hash %= mod;
	        	str_hash = str_hash * p;
	        	str_hash %= mod;
	        	str_hash += str.charAt(i) - 'a' + 1; //p^0 is 1 so no benefit in multiplying
	        	str_hash %= mod;
	        	if(str_hash < 0)
	        		str_hash += mod;
        	}
        }
        return -1;
	}
}