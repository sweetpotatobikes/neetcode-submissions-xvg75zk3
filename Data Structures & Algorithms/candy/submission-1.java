class Solution {
    public int candy(int[] ratings) {
        final int N = ratings.length;
        int total = N; // each child has one candy to start

        int i = 1;
        while (i < N) {
            // same ratings
            if (ratings[i - 1] == ratings[i]) {
                i++;
                continue;
            }

            int increasingSlope = 0;
            while (i < N && ratings[i - 1] < ratings[i]) {
                increasingSlope++;
                total += increasingSlope;
                i++;
            }

            int decreasingSlope = 0;
            while (i < N && ratings[i] < ratings[i - 1]) {
                decreasingSlope++;
                total += decreasingSlope;
                i++;
            }

            int overlap = increasingSlope + decreasingSlope;
            int needed = Math.max(increasingSlope, decreasingSlope);
            total -= overlap - needed;
        }
        return total;
    }
}