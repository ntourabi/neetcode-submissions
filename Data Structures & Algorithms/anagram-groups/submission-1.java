class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Look at each string
        //Does results contain a group anagram where that string would fit.
        // Y - Add to that group anagram list.
        // N - Create new group anagram list. 
        List<List<String>> results = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (String str : strs) {
            if (seen.contains(str)) continue;
            boolean found = false;
            for (List<String> result : results) {
                if (isAnagramOf(result.get(0), str)) {
                    result.add(str);
                    seen.add(str);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                results.add(temp);
            }
        }
        return results;
    }

    public boolean isAnagramOf(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : c1) {
            if (hm.containsKey(c)) hm.put(c, hm.get(c)+1);
            else hm.put(c, 1);
        }

        for (char c : c2) {
            if (hm.containsKey(c) && hm.get(c) > 0) {
                hm.put(c, hm.get(c)-1);
            } else {
                return false;
            }
        }
        return true;
    }
}
