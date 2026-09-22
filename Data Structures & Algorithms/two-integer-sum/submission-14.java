class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solution2(nums, target);
    }

    // HashMap method: O(n) time?
    public int[] solution2(int[] nums, int target) {
        //Number keys, index values.
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int jVal = target - nums[i];
            if (seen.containsKey(jVal)) return new int[]{seen.get(jVal), i};
            else seen.put(nums[i], i);
        }
        throw new RuntimeException("Invalid Input");
    }


    // Brute Force Method: O(n^2) time
    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        throw new RuntimeException("Invalid Input");
    }
}
