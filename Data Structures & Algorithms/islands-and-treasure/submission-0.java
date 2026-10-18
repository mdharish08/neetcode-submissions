class Solution {

    private final int[][] dir = new int[][] {{0,1}, {0,-1},{-1,0},{1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length , m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    dfs(grid,i,j,0);
                }
            }
        }
    }

    private void dfs(int[][] grid,int i ,int j,int dis){
        if( i < 0 || j < 0 || i == grid.length || j == grid[0].length){
            return;
        }
        if(grid[i][j] == -1 || grid[i][j] < dis ){
            return;
        }
        grid[i][j] = dis;
        for(int[] d : dir){
            dfs(grid,d[0] + i,d[1] + j,dis+1);
        }
    }
}
