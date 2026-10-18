class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            map[s.charAt(i) - 'a'] = i;
        }
        int right = 0 , left = 0;

        while(right < s.length()){
            int cur = left;
            while(cur <= right){
                int c = s.charAt(cur) - 'a';
                right = Math.max(right,map[c]);
                ++cur; 
            }
            ans.add(right - left + 1);
            right = right + 1;
            left = right;
        }

        return ans;
    }
}
