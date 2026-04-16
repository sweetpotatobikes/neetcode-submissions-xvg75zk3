class Solution {
    private static final String[] MAPPING = { "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        result.add("");

        for (char digit : digits.toCharArray()) {
            List<String> combinations = new ArrayList<>();
            for (String s : result) {
                for (char c : MAPPING[digit - '0'].toCharArray()) {
                    combinations.add(s + c);
                }
            }
            result = combinations;
        }
        return result;
    }
}
