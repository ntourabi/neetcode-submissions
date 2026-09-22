class Solution {
    //the canonical interview solution is to use a HashMap of seen characters and their indices.
    
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int left = 0;
        int right = 0;
        int longest = 0;
        Set<Character> seen = new HashSet<>();
        char[] cs = s.toCharArray();
        while (right < cs.length) {
            while (seen.contains(cs[right])) {
                seen.remove(cs[left]);
                left++;
            } 

            seen.add(cs[right]);
            right++;
            if (longest < (right-left)) longest = right-left;
        }
        return longest;
    }
}
