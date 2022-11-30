//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java

class Solution{
    static int subsetXOR(int arr[], int N, int K) {
        int count = 0, n = (int) Math.pow(2, N);
        for(int i = 0;i < n;i++){
            int temp = i, cur = 0, j = 0;
            while(temp != 0){
                if((temp & 1) == 1)
                    cur ^= arr[j];
                j++;
                temp = temp >> 1;
            }
            if(cur == K)
                count++;
        }
        return count;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            int N = s.nextInt();
            int K = s.nextInt();
            int arr[] = new int[N];
            for(int i =0;i<N;i++)
            {
                arr[i] =s.nextInt();
            }
            Solution ob = new Solution();
            System.out.println(ob.subsetXOR(arr,N,K));
        }
    }
}
// } Driver Code Ends