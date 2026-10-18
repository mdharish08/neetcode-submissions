class Solution {

    private int findNumDistinct(String s , String t, int i , int j,int[][] dp){
        if(j == t.length()){
            return 1;
        }
        if(i == s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == t.charAt(j)){
             dp[i][j] = findNumDistinct(s,t,i+1 , j+1,dp) + findNumDistinct(s,t,i+1, j,dp);
        }else{
             dp[i][j] = findNumDistinct(s,t,i+1,j,dp);
        }
        return dp[i][j];
    }
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }
        return findNumDistinct(s,t,0,0,dp);
    }
}
