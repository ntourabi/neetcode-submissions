class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        //Create a hashmap representation of string s.
        HashMap<Character, Integer> map_s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (map_s.containsKey(currentChar)) {
                map_s.put(currentChar, map_s.get(currentChar) + 1);
            } else {
                map_s.put(s.charAt(i), 1);
            }
        }

        //Go through t and update hashmap accordingly.
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (map_s.containsKey(currentChar)) {
                map_s.put(currentChar, map_s.get(currentChar)-1);
            } else {
                return false;
            }
        }

        System.out.println(map_s);
        Collection<Integer> values = map_s.values();
        for (int value : values) {
            if (value != 0) return false;
        }

        return true;

    }
}
