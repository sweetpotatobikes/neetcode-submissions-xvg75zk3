class Solution {
    public int[][] merge(int[][] intervals) {
        final int start = 0;
        final int end = 1;

        Arrays.sort(intervals, (a,b) -> a[start]-b[start]);
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            
            if (curr[start] <= prev[end]) {
                // MERGE
                prev[end] = Math.max(prev[end], curr[end]);
            } else {
                result.add(prev);
                prev = curr;
            }
        }

        result.add(prev);
        return result.toArray(int[][]::new);
    }
}
