class Solution {
    public boolean isPalindrome(String s) {
        String s2 = "";
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                s2 = s2 + Character.toLowerCase(c);
            }
        }
        cs = s2.toCharArray();
        for (int i = 0; i < cs.length/2; i++) {
            if (cs[i] != cs[cs.length-1-i]) return false;
        }

        return true;
    }
}
