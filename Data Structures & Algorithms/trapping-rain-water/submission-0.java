class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n] , rightMax = new int[n];

        int max = 0;
        for(int i = 0 ; i < n ; i++){
            leftMax[i] = max;
            max = Math.max(max, height[i]);
        }
        max = 0;
        for(int j = n - 1 ; j >= 0 ; j--){
            rightMax[j] = max;
            max = Math.max(max, height[j]);
        }
        int ans = 0;

        for(int i = 0 ; i < n ; i++){
            int container = Math.min(leftMax[i], rightMax[i]);
            if(container > 0 && container - height[i] > 0){
                ans += container - height[i];
            }
        }
        return ans;
    }
}
