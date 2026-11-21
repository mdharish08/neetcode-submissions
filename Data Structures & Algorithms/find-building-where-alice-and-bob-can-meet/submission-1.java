class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int a = queries[q][0];
            int b = queries[q][1];

            // Normalize starting positions
            int left = Math.min(a, b);
            int right = Math.max(a, b);

            // Both already start at the same building
            if (left == right) {
                result[q] = left;
                continue;
            }

            // Alice can directly reach Bob's building
            if (heights[right] > heights[left]) {
                result[q] = right;
                continue;
            }

            // Search for the first common reachable building
            int answer = -1;

            for (int i = right + 1; i < heights.length; i++) {
                if (heights[i] > heights[left] &&
                    heights[i] > heights[right]) {

                    answer = i;
                    break;
                }
            }

            result[q] = answer;
        }

        return result;
    }
}
