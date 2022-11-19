//{ Driver Code Starts
import java.util.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int arr[] = new int[n]; 
			for(int i=0;i<n;i++)
			{
				arr[i] = sc.nextInt();
			}
		
			Solution obj = new Solution();
			obj.selectionSort(arr, n);
			
			for(int i=0;i<n;i++)
		    	System.out.print(arr[i]+" ");
		    System.out.println();
			t--;
		}
		
	}
}

// } Driver Code Ends


class Solution
{
	int  select(int arr[], int i)
	{
	    int n = arr.length, min = arr[i], result = i;
        for(int j = i + 1;j < n;j++){
            if(arr[j] < min){
                result = j;
                min = arr[j];
            }
        }
        return result;
	}
	
	void selectionSort(int arr[], int n)
	{
	    for(int i = 0;i < n;i++){
	        int index = select(arr, i);
	        int temp = arr[index];
	        arr[index] = arr[i];
	        arr[i] = temp;
	    }
	}
}