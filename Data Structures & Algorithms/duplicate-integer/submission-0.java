class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> existingNums = new HashSet<>();
        for (int num : nums) {
            if (existingNums.contains(num)) {
                return true;
            } else {
                existingNums.add(num);
            }
        }
        return false;
    }
}
