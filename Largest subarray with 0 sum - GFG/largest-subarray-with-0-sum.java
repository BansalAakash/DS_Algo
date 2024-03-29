//{ Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int nums[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0, max = 0;
        for(int i = 0;i < n;i++){
            curSum += nums[i];
            if(curSum == 0)
                max = i + 1;
            if(map.containsKey(curSum))
                max = Math.max(max, i - map.get(curSum));
            else map.put(curSum, i);
        }
        return max;
    }
}