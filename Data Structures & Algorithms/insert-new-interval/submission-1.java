class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        final int start = 0;
        final int end = 1;
        List<int[]> result = new ArrayList();

        for (int[] interval : intervals) {
            if (newInterval[end] < interval[start]) {
                result.add(newInterval);
                newInterval = interval;
            } else if (interval[end] < newInterval[start]) {
                result.add(interval);
            } else {
                newInterval[start] = Math.min(newInterval[start], interval[start]);
                newInterval[end] = Math.max(newInterval[end], interval[end]);
            }
        }

        result.add(newInterval);
        return result.toArray(int[][]::new);
    }
}
