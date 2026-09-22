class Solution {
    public boolean isPalindrome(String s) {
        return sol3(s);
    }

    public boolean sol3(String s) {
        int left = 0;
        int right = s.length() - 1;

        char[] cs = s.toCharArray();

        while (left < right) {
            while (!isAlphanumeric(cs[left]) && left < right) {
                left++;
            }

            while (!isAlphanumeric(cs[right]) && left < right) {
                right--;
            }
            if (Character.toLowerCase(cs[left]) != Character.toLowerCase(cs[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isAlphanumeric(char c) {
        c = Character.toLowerCase(c);
        return (('0' <= c && c <= '9') || ('a' <= c && c <= 'z'));
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
