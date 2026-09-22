class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == difference) {
                    if (i != j) return new int[]{i, j};
                }
            }
        }
        return null; //this shouldn't occur.
    }
}
