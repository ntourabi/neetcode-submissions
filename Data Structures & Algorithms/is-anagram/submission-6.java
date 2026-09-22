class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (sMap.containsKey(c)) sMap.put(c, sMap.get(c)+1);
            else sMap.put(c, 1);
        }

        for (char c : t.toCharArray()) {
            if (sMap.containsKey(c)) {
                int v = sMap.get(c) - 1;
                if (v < 0) return false;
                else sMap.put(c, v);
            }
            else return false;
        }

        return true;
    }
}
