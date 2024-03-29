//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int bs(int[] row, int low, int high){
        while(low < high){
            int mid = low + (high - low) / 2;
            if(row[mid] == 0)
                low = mid + 1;
            else high = mid;
        }
        return low - 1;
    }
    int rowWithMax1s(int arr[][], int n, int m) {
        int min = m, maxRow = -1;
        for(int i = 0;i < n;i++){
            if(arr[i][0] == 1)
                return i;
            if(arr[i][m - 1] == 0)
                continue;
            int cur = bs(arr[i], 0, m - 1);
            if(cur < min){
                min = cur;
                maxRow = i;
            }
        }
        return maxRow;
    }
}