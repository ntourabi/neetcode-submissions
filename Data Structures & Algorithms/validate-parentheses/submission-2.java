class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false; //valid solutions will always be even.
        
        Stack<Character> charstack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (isOpeningChar(chars[i])) {
                charstack.push(chars[i]);
            } else {
                if (charstack.size() == 0) return false;
                char current = charstack.pop();
                if (!(getCorrespondingChar(current) == chars[i])) return false;
            }
        }
        if (charstack.size() > 0) return false;
        return true;
    }

    public boolean isOpeningChar(char x) {
        if (x == '{' || x == '[' || x == '(') return true;
        return false;
    }

    public char getCorrespondingChar(char x) {
        if (x == '[') return ']';
        if (x == '{') return '}';
        if (x == '(') return ')';
        return '#';
    }

    //Iterate throughout the entire charArray representation of string s.
    //Push when you find an opening character.
    //When you find a closing character, check if it complements the character at the top of the stack (peek)
    //  - If it does, pop it and keep going.
    //  - If it doesn't, it's not valid. Return false.
    //If you reach the end, check the stack is empty. Empty means return true, else return false.
}
