class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        final int start = 0;
        final int end = 1;

        Arrays.sort(intervals, (a,b) -> a[start]-b[start]);
        int result = 0;
        int prevEnd = intervals[0][end];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prevEnd <= curr[start]) {
                prevEnd = curr[end];
            } else {
                result++;
                prevEnd = Math.min(prevEnd, curr[end]);
            }
        }
        return result;
    }
}
