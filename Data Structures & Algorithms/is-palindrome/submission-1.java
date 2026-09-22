class Solution {
    public boolean isPalindrome(String s) {
        return sol2(s);
    }

    public boolean sol2(String s) {
        String cleaned = "";
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                cleaned += Character.toLowerCase(c);
            }
        }

        int left = 0;
        int right = cleaned.length()-1;
        char[] cs = cleaned.toCharArray();

        while (left < right) {
            if (cs[left] != cs[right]) return false;
            left++;
            right--;
        }
        return true;
    }


    /**
    * I have no idea when this was done lmao. 
    */
    public boolean oldSolution(String s) {
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
