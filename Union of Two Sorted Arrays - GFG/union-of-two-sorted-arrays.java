//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int m, int n)
    {
        int i = 0, j = 0, cur = -1;
        ArrayList<Integer> result = new ArrayList<>();
        
        while(i < m || j < n){
            if(i == m)
                cur = arr2[j++];
            else if(j == n)
                cur = arr1[i++];
            else{
                if(arr1[i] == arr2[j]){
                    cur = arr1[i];
                    i++;
                    j++;
                } else if(arr1[i] < arr2[j])
                    cur = arr1[i++];
                else cur = arr2[j++];
            }
            if(result.size() == 0 || cur != result.get(result.size() - 1))
                result.add(cur);
        }
        return result;
    }
}



