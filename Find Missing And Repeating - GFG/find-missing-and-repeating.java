//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int[] findTwoElement(int arr[], int n) {
        int[] result = {0,0};
        int i = 0;
        while(i < n){
            if(arr[i]!= i + 1){
                if(arr[arr[i] - 1] == arr[i]){
                    result[0] = arr[i];
                    i++;
                }
                else
                    swap(arr, i, arr[i] - 1);
            } else i++;
        }
        for(i = 0;i < n;i++)
            if(arr[i] != i + 1){
                result[1] = i + 1;
                break;
            }
        return result;
    }
}