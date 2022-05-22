class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        int n = heights.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        leftSmaller[0] = -1;
        rightSmaller[n - 1] = n;

        //Calculating leftSmaller and rightSmaller
        Stack<Integer> leftStack = new Stack<>();
        leftStack.push(0);
        Stack<Integer> rightStack = new Stack<>();
        rightStack.push(n - 1);
        for(int i = 1;i < n;i++){
            while(!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[n - i - 1]) rightStack.pop();
            if(rightStack.isEmpty()) rightSmaller[n - i - 1] = n;
            else rightSmaller[n - i - 1] = rightStack.peek();
            rightStack.push(n - i - 1);

            while(!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[i]) leftStack.pop();
            if(leftStack.isEmpty()) leftSmaller[i] = -1;
            else leftSmaller[i] = leftStack.peek();
            leftStack.push(i);
        }
        int maxArea = 0;
        for(int i = 0;i < n;i++)
            maxArea = Math.max(maxArea, heights[i] * (rightSmaller[i] - leftSmaller[i] - 1));
        return maxArea;

    }
}