class Solution {

    public record Edge(int v , int weight){};
    public int networkDelayTime(int[][] times, int n, int k) {
          int[] dist = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[k] = 0;
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0 ; i < n + 1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : times){
            adj.get(e[0]).add(new Edge(e[1],e[2]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2) -> Integer.compare(e1.weight(), e2.weight()));
        pq.offer(new Edge(k,0));

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(Edge v : adj.get(e.v())){
                int curWeight = e.weight() + v.weight();
                if(curWeight < dist[v.v()]){
                    dist[v.v()] = curWeight;
                    pq.offer(new Edge(v.v(), curWeight));
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i <= n ; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }
        return ans ;
    }
}
