class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> row = topoSort(rowConditions,k);
        if(row.size() != k){
            return new int[0][0];
        }
        List<Integer> col = topoSort(colConditions, k);
        if(col.size() != k){
            return new int[0][0];
        }
        int[][] ans = new int[k][k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < col.size(); i++){
            map.put(col.get(i), i);
        }
        for(int i = 0 ; i < k ; i++){
            ans[i][map.get(row.get(i))] = row.get(i);
        }
        return ans;
    }

    private List<Integer> topoSort(int[][] edges,int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <= n ; i++){
            adj.add(new ArrayList<>());
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[n+1];
        for(int[] r : edges){
            List<Integer> l = adj.get(r[0]);
            if(!l.contains(r[1])){
                l.add(r[1]);
                indegree[r[1]]++;
            }
        }

        for(int i = 1; i <=n;i++){
            if(indegree[i] == 0){
                ans.add(i);
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u = q.poll();

            for(int v : adj.get(u)){
                 indegree[v]--;
                 if(indegree[v] == 0){
                    ans.add(v);
                    q.add(v);
                 }
            }
        }
        return ans.size() == n ? ans : Collections.emptyList();
    }
}