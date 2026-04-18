/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int N = intervals.size();
        if (N < 2) return N;

        int[] starts = new int[N], ends = new int[N];
        for (int i = 0; i < N; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int result = 0;
        int end = 0;

        for (int start = 0; start < N; start++) {
            if (starts[start] < ends[end]) {
                result++;
            } else end++;
        }
        return result;
    }
}
