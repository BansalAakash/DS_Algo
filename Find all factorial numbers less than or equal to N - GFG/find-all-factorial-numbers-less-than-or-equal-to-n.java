//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            long N=sc.nextLong();
			
            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for(long num : ans){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

//User function Template for Java
class Solution{
    void f(int i, long N, ArrayList<Long> list){
        long x = list.get(list.size() - 1) * i;
        if(x > N)
            return;
        list.add(x);
        f(i + 1, N, list);
    }
    static ArrayList<Long> factorialNumbers(long N){
        ArrayList<Long> list = new ArrayList<>();
        list.add(1L);
        Solution s = new Solution();
        s.f(2, N, list);
        return list;
    }
}