class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();

        // base case, n = 0
        dp.add(new ArrayList<>());
        dp.get(0).add("");

        for (int total = 1; total <= n; total++) {
            List<String> curr = new ArrayList<>();

            for (int left = 0; left < total; left++) {
                int right = total - left - 1;
                
                for (String leftString : dp.get(left)) {
                    for (String rightString : dp.get(right)) {
                        curr.add("(" + leftString + ")" + rightString);
                    }
                }
            }
            dp.add(curr);
        }
        return dp.get(n);
    }
}
