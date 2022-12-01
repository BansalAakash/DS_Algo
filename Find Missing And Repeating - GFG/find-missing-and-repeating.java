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
    int[] findTwoElement(int arr[], int n) {
        int xor = 0;
        for(int i = 1;i <= n;i++)
            xor = xor ^ i ^ arr[i - 1];
        int temp = xor, setBit = 0;
        while((temp & 1) != 1){
            temp = temp >> 1;
            setBit++;
        }
        int part1 = 0, part2 = 0;
        for(int i = 1;i <= n;i++){
            if(((arr[i - 1] >> setBit) & 1) == 1)
                part1 ^= arr[i - 1];
            else part2 ^= arr[i - 1];
            
            if(((i >> setBit) & 1) == 1)
                part1 ^= i;
            else part2 ^= i;
        }
        for(int i : arr){
            if(i == part1)
                break;
            else if(i == part2){
                temp = part1;
                part1 = part2;
                part2 = temp;
                break;
            }
        }
        return new int[]{part1, part2};
     }
}