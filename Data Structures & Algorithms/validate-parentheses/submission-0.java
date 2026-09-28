class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; //valid solutions will always be even.
        Stack<Character> firsthalf = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < (s.length() / 2); i++) {
            firsthalf.push(chars[i]);
        } 
        for (int i = (s.length() / 2); i < s.length(); i++) {
            char current = firsthalf.pop();
            if (!(getCorrespondingChar(current) == chars[i])) {
                return false;
            }
        }
        return true;
    }

    public char getCorrespondingChar(char x) {
        if (x == '[') return ']';
        if (x == '{') return '}';
        if (x == '(') return ')';
        return '#';
    }
}
