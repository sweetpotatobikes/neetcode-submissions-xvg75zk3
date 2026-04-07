class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                char opening = stack.pop();
                if (c == ')' && opening != '(') return false;
                if (c == '}' && opening != '{') return false;
                if (c == ']' && opening != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
