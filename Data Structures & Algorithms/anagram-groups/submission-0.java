class Solution {
    //Main Method
    //
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();
        List<String> wordset = new ArrayList<>();
        for (String word : strs) {
            wordset.add(word);
        }
        while (wordset.size() > 0) {
            //Pick a word and create a list containing it and its anagrams.
            List<String> minigroup = new ArrayList<>();
            String anchor = wordset.get(0);
            for (String word : wordset) {
                if (isAnagram(anchor, word)) {
                    minigroup.add(word);
                }
            }
            for (String word : minigroup) {
                wordset.remove(word);
            }
            groups.add(minigroup);
        }
        return groups;
    }

    public Boolean isAnagram(String w1, String w2) {
        if (w1.length() != w2.length()) return false;
        //Represent the alphabet with indices 0-25.
        int[] count = new int[26];
        for (int i = 0; i < w1.length(); i++) {
            //'a' has the ASCII value 97. Taking it away from each letter converts it into its corresponding index.
            count[w1.charAt(i) - 'a']++;
            count[w2.charAt(i) - 'a']--;
        }
        for (int x : count) {
            if (x != 0) return false;
        }
        return true;
    }
}
