class Solution {
    private int LEN;
    private boolean[][] dp;

    public List<List<String>> partition(String s) {
        LEN = s.length();
        dp = new boolean[LEN][LEN];

        for (int i = 0; i < LEN; i++) dp[i][i] = true;

        for (int len = 2; len <= LEN; len++) {
            for (int start = 0; start <= LEN - len; start++) {
                int end = start + len - 1;
                if (s.charAt(end) == s.charAt(start) &&
                (dp[start + 1][end - 1] || len == 2)) {
                    dp[start][end] = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<String>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        if (start == LEN) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < LEN; end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
