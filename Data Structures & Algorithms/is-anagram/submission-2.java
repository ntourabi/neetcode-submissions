class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (Character x : s.toCharArray()) {
            if (hm.containsKey(x)) {
                hm.put(x, hm.get(x)+1);
            } else {
                hm.put(x, 1);
            }
        }
        for (Character y : t.toCharArray()) {
            if (hm.containsKey(y) && hm.get(y) > 0) {
                hm.put(y, hm.get(y)-1);
            } else {
                System.out.println("hi");
                return false;
            }
        }
        for (Integer x : hm.values()) {
            if (x != 0) return false;
        }
        return true;
    }
}
