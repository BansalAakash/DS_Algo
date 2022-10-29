//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);    //first elem is node, second is weight
        HashMap<Integer, ArrayList<int[]>> graph = new HashMap<>();
        ArrayList<Integer> dist = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            dist.add(Integer.MAX_VALUE);
            parent.add(i);
        }
        dist.set(1, 0);
        q.add(new int[]{1, 0});
        for(int i = 0;i <= n;i++)
            graph.put(i, new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] i : graph.get(cur[0])){
                if(cur[1] + i[1] < dist.get(i[0])){
                    dist.set(i[0], cur[1] + i[1]);
                    q.add(new int[] {i[0], dist.get(i[0])});
                    parent.set(i[0], cur[0]);
                }
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        if(n == 1 || parent.get(n) != n){
            int i = n;
            while(parent.get(i) != i){
                list.addFirst(i);
                i = parent.get(i);
            }
            list.addFirst(1);
        } else list.add(-1);
        return list;
    }
}