class Solution {
    public boolean isAnagram(String s, String t) {
        //return sol1(s, t);
        return sol2(s, t);   
    }

    public boolean sol1(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c)+1);
            } else {
                hm.put(c, 1);
            }
        }

        for (char c : t.toCharArray()) {
            if (hm.containsKey(c) && hm.get(c) > 0) {
                hm.put(c, hm.get(c)-1);
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean sol2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }

        for (int c : counts) {
            if (c != 0) return false;
        }

        return true;
    }
}
