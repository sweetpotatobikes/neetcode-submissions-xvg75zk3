class Solution {
    public int countSubstrings(String s) {
        int N = s.length();
        if (N < 2) return N;

        int result = 0;
        int left = 0, right = 0;

        for (int i = 0; i < N; i++) {
            // odd case
            left = i;
            right = left;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }

            // even case
            left = i;
            right = left + 1;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                result++;
                left--;
                right++;
            }
        }
        return result;
    }
}
