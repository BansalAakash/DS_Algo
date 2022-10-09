class Solution{
	public int strStr(String str, String pat){
		if(pat.length() > str.length())
			return -1;
		String s = pat + "$" + str;
		int left = 0, right = 0, n = s.length();
		// int comp = 0;						//To track number of comparisons
		int[] z = new int[s.length()];
		for(int i = 1;i < n;i++){				//we start with first index cuz 0th index's z is always 0
			if(right < i){						//we are not inside z-box
				left = i;
				right = i;
				while(right < n && s.charAt(right) == s.charAt(right - left)){
					// comp++;
					right++;
				}
				z[i] = right - left;
				right--;
			} else{								//we are inside z-box
				z[i] = Math.min(z[i - left], right - i + 1);
				if(z[i - left] >= right - i + 1){							//The end of current character's coinciding with the right of current z box
					left = i;
					while(right < n && s.charAt(right) == s.charAt(right - left)){
						// comp++;
						right++;
					}
					z[i] = right - left;
					right--;
				}
			}
		}
		// System.out.println("Did " + comp + " comparisons for length " + n);
		for(int i = 0;i < n;i++)
			if(z[i] == pat.length())
				return i - pat.length() - 1;
		return -1;
	}
}