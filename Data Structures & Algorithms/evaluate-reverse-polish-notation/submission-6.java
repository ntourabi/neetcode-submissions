class Solution {
    public int evalRPN(String[] tokens) {
        return solution1(tokens);
    }

    public int solution1(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Set.of("+", "-", "*", "/"));
        for (String t : tokens) {
            if (operators.contains(t)) {
                String right = stack.pop();
                String left = stack.pop();
                stack.push(evaluate(left, t, right));
            } else stack.push(t);
        }
        return Integer.parseInt(stack.pop());
    }

    public String evaluate(String left, String op, String right) {
        int l = Integer.parseInt(left);
        int r = Integer.parseInt(right);
        int ans = switch (op) {
            case "+" -> l + r;
            case "-" -> l - r;
            case "*" -> l * r;
            case "/" -> l / r;
            default -> throw new RuntimeException("Undefined.");
        };
        return Integer.toString(ans);
    }
}
