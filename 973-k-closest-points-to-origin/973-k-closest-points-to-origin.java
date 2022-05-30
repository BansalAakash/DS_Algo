class Point{
    int x;
    int y;
    double d;
    public Point(int a, int b){
        x = a;
        y = b;
        d = Math.sqrt(x * x + y * y); //distance to the origin
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> q = new PriorityQueue<>((a, b)-> (a.d < b.d) ? 1 : -1);
        for(int[] point : points){
            q.add(new Point(point[0], point[1]));
            if(q.size() > k) q.remove();
        }
        int[][] result = new int[k][2];
        int i = 0;
        while(!q.isEmpty()){
            Point p = q.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }
        return result;
    }
}