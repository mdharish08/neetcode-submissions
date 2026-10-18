class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length , m = matrix[0].length;   
        for(int j = 0 ; j < m ; j++){
            int left = 0 , right = n - 1;
            while(left < right){
                int temp = matrix[left][j];
                matrix[left][j] = matrix[right][j];
                matrix[right][j] = temp;

                left++;
                right--;
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
    
}
