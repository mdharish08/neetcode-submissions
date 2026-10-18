class Solution {

    private final int[][] dir = new int[][] {{0,1}, {0,-1},{-1,0},{1,0}};
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[] {i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int[] d : dir){
                int r = d[0] + cur[0] , c = d[1] + cur[1];

                if(r < 0 || c < 0 || r == n || c == m ||  grid[r][c] != Integer.MAX_VALUE){
                    continue;
                }
                grid[r][c] = grid[cur[0]][cur[1]] + 1;
                queue.offer(new int[] {r,c});
            }
        }
    }
}
