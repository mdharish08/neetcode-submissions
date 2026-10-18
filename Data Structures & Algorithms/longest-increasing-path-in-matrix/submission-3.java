class Solution {
    private int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0, n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(
                    ans, 1 + getLongestIncreasingPath( i, j, matrix, dp));
            }
        }
        return ans;
    }

    private int getLongestIncreasingPath(int i, int j, int[][] matrix, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = 0;

        for (int[] d : dir) {
            int r = i + d[0];
            int c = j + d[1];

            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length
                && matrix[r][c] > matrix[i][j]) {
                dp[i][j] = Math.max(dp[i][j], 1 + getLongestIncreasingPath(r, c, matrix, dp));
            }
        }

        return dp[i][j];
    }
}
