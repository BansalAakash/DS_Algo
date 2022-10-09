import java.util.*;
class Solution{
	int[] lps(String pat){
		int n = pat.length(), i = 1, j = 0;
		int[] lps = new int[n];
		while(i < n){
			while(i < n && pat.charAt(i) == pat.charAt(j)){
				lps[i] = j + 1;
				i++;
				j++;
			}
			if(j == 0)
				i++;
			j = lps[Math.max(0, j - 1)];
		}
		return lps;
	}
	int strStr(String str, String pat){
		int m = str.length(), n = pat.length(), i = 0, j = 0;
		if(m < n)
			return -1;
		int[] lps = lps(pat);
		while(i < m){
			while(i < m && j < n && str.charAt(i) == pat.charAt(j)){
				i++;
				j++;
			}
			if(j == n)
				return i - j;
			if(j == 0)
				i++;
			j = lps[Math.max(0, j - 1)];
		}
		return -1;
	}
}