class Solution {
    public boolean isAnagram(String s, String t) {
        return solution1_arrays(s, t);
    }

    //a=97, z=122
    //A=65, Z=90
    public boolean solution1_arrays(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') counts[c-97]++;
            else counts[c-65]++;
        }

        for (char c : t.toCharArray()) {
            if (c >= 'a' && c <= 'z') counts[c-97]--;
            else counts[c-65]--;
        }

        for (int c : counts) {
            if (c != 0) return false;
        }

        return true;
    }
}
