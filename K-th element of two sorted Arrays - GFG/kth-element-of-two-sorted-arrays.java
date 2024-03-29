//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
        public long kthElement( int arr1[], int arr2[], int n1, int n2, int k) {
        if(n1 > n2)
            return kthElement(arr2, arr1, n2, n1, k);
        int n = n1 + n2, low = Math.max(0, k - n2), high = Math.min(k, n1);
        int cut1 = 0, cut2 = 0, l1 = 0, l2 = 0, r1 = 0, r2 = 0;
        while(low <= high){
            cut1 = low + (high - low) / 2;
            cut2 = k - cut1;
            l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];
            if(l1 <= r2 && l2 <= r1)
                break;
            if(l1 > r2)
                high = cut1 - 1;
            else low = cut1 + 1;
        }
        return Math.max(l1, l2);
    }
}