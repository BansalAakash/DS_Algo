class Solution{
	String reverse(String str){
		StringBuilder s = new StringBuilder(str);
		int i = 0, j = str.length() - 1;
		while(i < j){
			char temp = s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, temp);
			i++;j--;
		}
		return s.toString();
	}
	public String shortestPalindrome(String s) {
        int i = 0, n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        while(i < n && !s.substring(0, n - i).equals(rev.substring(i))) i++;
        return rev.substring(0, i) + s;
    }
}