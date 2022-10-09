import java.util.*;
class Solution{
	int[] lps(String pat){
		int n = pat.length(), i = 1, j = 0;
		int[] lps = new int[n];
		while(i < n){
			if(pat.charAt(i) == pat.charAt(j)){
				while(i < n && pat.charAt(i) == pat.charAt(j)){
					lps[i] = j + 1;
					i++;
					j++;
				}
				j = lps[Math.max(0, j - 1)];
			}
			else
				i++;
		}
		// System.out.println(Arrays.toString(lps));
		return lps;
	}
	public int strStr(String str, String pat){
		if(pat.length() > str.length())
			return -1;
		int[] lps = lps(pat);
		int i = 0, j = 0, m = str.length(), n = pat.length();
		while(i < m){
			if(str.charAt(i) == pat.charAt(j))
				while(i < m && j < n && str.charAt(i) == pat.charAt(j)){
					i++;
					j++;
				}
			else if(j == 0)
				i++;
			if(j == n)
				return i - j;
			j = lps[Math.max(0, j - 1)];
		}
		return -1;
	}
}