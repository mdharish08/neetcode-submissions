class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[][] sortedQueries = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            sortedQueries[i] = new int[] {queries[i], i};
        }
        Arrays.sort(sortedQueries, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int[] result = new int[queries.length];
        for(int[] q : sortedQueries){
            while(i < intervals.length && intervals[i][0] <= q[0]){
                pq.offer(new int[] {intervals[i][1] - intervals[i][0] + 1, intervals[i][1]});
                i++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < q[0]){
                pq.poll();
            }
            result[q[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return result;
    }
}
