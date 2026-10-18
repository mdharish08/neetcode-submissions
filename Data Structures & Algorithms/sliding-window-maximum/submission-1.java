class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int i = 0;
        Deque<Integer> q = new LinkedList<>();
        int left = 0 , right = 0;
        while(right < n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[right]){
                q.removeLast();
            }
            q.addLast(right);
            if(q.getFirst() < left){
                q.removeFirst();
            }
            if(right + 1 >= k){
                ans[i++] = nums[q.getFirst()];
                left++;
            }
            right++;
        }
        return ans;
    }
}
