class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String s : strs) {
            List<Integer> code = encode(s);
            if (map.containsKey(code)) {
                map.get(code).add(s);
            } else {
                List<String> group = new ArrayList<>();
                group.add(s);
                map.put(code, group);
            }
        }

        for (List<Integer> key : map.keySet()) {
            groups.add(map.get(key));
        }

        
        return groups;
    }

    public List<Integer> encode(String s1) {
        int[] alphabet = new int[26];
        for (char c : s1.toCharArray()) {
            alphabet[c-97]++;
        }
        return Arrays.stream(alphabet).boxed().toList();
    }
}
