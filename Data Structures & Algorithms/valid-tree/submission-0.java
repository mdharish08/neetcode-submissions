class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean visited[] = new boolean[n];

        if(dfs(adj,visited,0,-1)){
            return false;
        }

        return  IntStream.range(0, visited.length)
                .allMatch(i -> visited[i]);

    }

    private final boolean dfs(List<List<Integer>> adj,boolean[] visited,int cur,int par){
        visited[cur] = true;
        for(int e : adj.get(cur)){
            if(e != par && visited[e]){
                return true;
            }
            if(!visited[e] && dfs(adj,visited,e,cur)){
                return true;
            }
        }

        return false;
    }
}
