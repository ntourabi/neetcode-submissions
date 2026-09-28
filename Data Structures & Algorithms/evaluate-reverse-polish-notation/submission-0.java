class Solution {
    public int evalRPN(String[] tokens) {
        return solution1(tokens);
    }

    public int solution1(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String t : tokens) {
            System.out.println(t);
            if (isSymbol(t)) {
                String right = stack.pop();
                String left = stack.pop();
                String result = Integer.toString(evaluate(left, t, right));
                stack.push(result);
            } else stack.push(t);
        }
        return Integer.parseInt(stack.pop());
    }

    public int evaluate(String left, String op, String right) {
        int l = Integer.parseInt(left);
        int r = Integer.parseInt(right);
        return switch (op) {
            case "+" -> l + r;
            case "-" -> l - r;
            case "*" -> l * r;
            case "/" -> l / r;
            default -> throw new RuntimeException("Undefined.");
        };
    }

    public boolean isSymbol(String token) {
        return (token.equals("+")) || token.equals("-") 
        || token.equals("*") || token.equals("/");
    }
}
