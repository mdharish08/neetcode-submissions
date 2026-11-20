class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        k = k % n;
        if(k == 0){
            return;
        }
        int index = 0 ;
        
        for(int i = n - k ; i < n; i++){
            ans[index++] = nums[i];
        }
        for(int i = 0; i < n - k; i++){
            ans[index++] = nums[i];
        }

        for(int i = 0 ; i < n;i++){
            nums[i] = ans[i];
        }
    }
}