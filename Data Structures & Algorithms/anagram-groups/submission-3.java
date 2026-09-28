class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        for (String str : strs) {
            List<String> group = findAnagramGroup(groups, str);
            if (group == null) groups.add(new ArrayList<String>(List.of(str)));
            else group.add(str);
        }
        return groups;
    }

    public List<String> findAnagramGroup(List<List<String>> groups, String str) {
        for (List<String> g : groups) {
            if (isAnagram(g.get(0), str)) return g;
        }
        return null;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<Character, Integer> charmap = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            if (charmap.containsKey(c)) charmap.put(c, charmap.get(c) + 1);
            else charmap.put(c, 1);
        }

        for (Character c : s2.toCharArray()) {
            if (charmap.containsKey(c)) {
                int v = charmap.get(c);
                if (v <= 0) return false;
                else charmap.put(c, v-1);
            } else return false;
        }
        return true;
    }
}
