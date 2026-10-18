class Solution {
    public void dfs(List<List<Integer>> adj,int i,boolean[] v){
        v[i] = true;
        
        for(int e : adj.get(i)){
            if(!v[e]){
                dfs(adj,e,v);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        int ans = 0;
        boolean[] visited = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                ++ans;
                dfs(adj,i,visited);
            }
        }

        return ans;
    }
}
