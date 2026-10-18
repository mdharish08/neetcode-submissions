class Solution {
    
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int[] nextSmallerLeft = new int[n];
        int[] nextSmallerRight = new int[n];

        for(int i = 0 ; i < n ; i++){
            if(st.empty()){
                nextSmallerLeft[i] = -1;
            }else {
                while(!st.empty() && heights[st.peek()] >= heights[i] ){
                    st.pop();
                }
                nextSmallerLeft[i] = !st.empty() ? st.peek() : -1;
            }
            st.push(i);
        }
        clearStack(st);
        for(int i = n-1 ; i >= 0 ; i--){
            if(st.empty()){
                nextSmallerRight[i] = -1;
            }else {
                while(!st.empty() && heights[st.peek()] >= heights[i] ){
                    st.pop();
                }
                nextSmallerRight[i] = !st.empty() ? st.peek() : -1;
            }
            st.push(i);
        }
        clearStack(st);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int height = heights[i];
            int left = nextSmallerLeft[i] != -1 ? nextSmallerLeft[i] + 1 : 0;
            int right = nextSmallerRight[i] != -1 ? nextSmallerRight[i] - 1 : n-1;
            int width = right - left + 1;
            ans = Math.max(ans, height * width);
        }
        return ans;
    }

    private void clearStack(Stack<Integer> st){
        while(!st.isEmpty()){
            st.pop();
        }
    }
}
