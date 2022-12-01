//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    void merge(long[] arr, int low, int mid, int high, long[] count){
        int i = low, j = mid + 1, k = 0;
        long[] temp = new long[high - low + 1];
        while(i <= mid || j <= high){
            if(i > mid || (j <= high && arr[j] < arr[i])){
                count[0] += mid - i + 1;
                temp[k++] = arr[j++];
            }
            else temp[k++] = arr[i++];
        }
        for(i = low, j = 0;i <= high;i++,j++)
            arr[i] = temp[j];
    }
    void mergeSort(long[] arr, int low, int high, long[] count){
        if(low == high)
            return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid, count);
        mergeSort(arr, mid + 1, high, count);
        merge(arr, low, mid, high, count);
    }
    static long inversionCount(long arr[], long N)
    {
        Solution s = new Solution();
        long[] count = {0};
        s.mergeSort(arr, 0, (int)N - 1, count);
        return count[0];
    }
}