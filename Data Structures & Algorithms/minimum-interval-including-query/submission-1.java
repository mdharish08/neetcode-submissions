class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] table = new int[10000001];
        Arrays.fill(table, Integer.MAX_VALUE);
        for(int[] interval : intervals){
            int length = interval[1] - interval[0] + 1;
            for(int i = interval[0] ; i <= interval[1]; i++){
                table[i] = Math.min(table[i], length);
            }
        }

        int[] result = new int[queries.length];
        for(int i = 0 ; i < queries.length; i++){
            var q = queries[i];
            result[i] = table[q] == Integer.MAX_VALUE ? -1 : table[q];
        }
        return result;
    }
}
