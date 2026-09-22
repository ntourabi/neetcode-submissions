class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> outer = new ArrayList<>();
        for (String str : strs) {
            List<String> group = getGroup(outer, str);
            if (group == null) {
                outer.add(new ArrayList<>(List.of(str)));
            } else {
                group.add(str);
            }
        }
        return outer;
    }

    public List<String> getGroup(List<List<String>> outer, String word) {
        for (List<String> inner : outer) {
            if (isAnagramOf(inner.get(0), word)) return inner;
        }
        return null;
    }

    public boolean isAnagramOf(String s1, String s2) {
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
