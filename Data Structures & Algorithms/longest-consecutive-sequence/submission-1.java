class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) seen.add(n);

        int result = 0;
        for (int n : seen) {
            if (!seen.contains(n - 1)) {
                int count = n;
                int streak = 1;
                while (seen.contains(count + 1)) {
                    count++;
                    streak++;
                }
                result = Math.max(result, streak);
            }
        }
        return result;
    }
}
