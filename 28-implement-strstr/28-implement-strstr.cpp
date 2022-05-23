class Solution {
public:
    int strStr(string haystack, string needle) {
        int idx,j;
        if(needle.length()==0)
            return 0;
        
        int len = haystack.length();
        
        for(int i = 0 ;i < len ; i++)
        {
            if(haystack[i]==needle[0])
            {
                 j=0;
                while(needle[j]==haystack[i+j])
                {
                    j++;
                    if(j==needle.length())
                        return i;
                    if(j>=len)
                        return -1;
                    
                }
                
            }
        }
        return -1;
    }
};