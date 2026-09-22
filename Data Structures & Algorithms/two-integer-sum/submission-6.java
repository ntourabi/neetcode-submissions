class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solution1(nums, target);
    }

    // Brute Force Method: O(n^2) time
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                else if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new RuntimeException("Invalid Input");
    }
}
