class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num :  nums) {
            if (counts.containsKey(num)) return true;
            counts.put(num, 1);
        }
        return false;
    }
}