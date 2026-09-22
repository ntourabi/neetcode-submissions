class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution1_bruteForce(nums);
    }

    public List<List<Integer>> solution2_(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        return results;
    }

    // Time: O(n^3)
    // Space: O(n)
    //
    // We set j = i+1, and k = j+1 because we don't want different permutations of the same combination.
    // - e.g. (i, j, k) and (j, i, k) and (k, i, j).
    // While it prevents index-level duplication, it doesn't prevent value-level duplication.
    // - e.g. nums = (0, 0, 0, 0)
    //
    // Collections.sort() will cost you O(klogk) to sort k elements.
    // Since we're always sorting 3 elements, O(3log3) = O(1).
    //
    public List<List<Integer>> solution1_bruteForce(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> candidate = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(candidate);
                        if (seen.add(candidate)) {
                            result.add(candidate);
                        }
                    }
                }
            }
        }
        return result;
    }
}
