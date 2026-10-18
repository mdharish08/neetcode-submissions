class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;   
        int[][] temp = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            int r = n - 1 - i;
            for(int j = 0; j < m ; j++){
                temp[j][r] = matrix[i][j];
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                matrix[i][j] = temp[i][j];
            }
        }
    }
}
