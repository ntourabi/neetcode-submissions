class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution1_bruteForce(nums);
    }

    public List<List<Integer>> solution1_bruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> candidate = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(candidate);
                        if (!result.contains(candidate)) result.add(candidate);
                    }
                }
            }
        }
        return result;
    }
}
