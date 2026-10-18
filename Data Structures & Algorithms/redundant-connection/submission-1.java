class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : edges){
           int u = e[0] , v = e[1];
           adj.get(u).add(v);
           adj.get(v).add(u);
           boolean[] visited = new boolean[n];
           if(hasCycle(adj,visited,n)){
              return e;
           }
        }
        return new int[] {-1,-1};
    }

    private boolean hasCycle(List<List<Integer>> adj,boolean[] visited,int n){
        for(int i = 1 ; i < n ; i++){
            if(visited[i] == false){
                if(hasCycle(adj,i,-1,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasCycle(List<List<Integer>> adj,int src,int parent, boolean[] visited){
        visited[src] = true;
        for(int e : adj.get(src)){
            if(e != parent){
                if(visited[e]){
                    return true;
                }
                if(hasCycle(adj,e,src,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}
