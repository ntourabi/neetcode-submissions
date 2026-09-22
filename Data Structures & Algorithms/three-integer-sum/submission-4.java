class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return solution2_binarySearch(nums);
    }

    // Time: O(n^2 logn)
    // Space: O(n^2)
    public List<List<Integer>> solution2_binarySearch(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        Set<List<Integer>> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int numsK = 0 - (nums[i] + nums[j]);
                if (!kExists_binarySearch(nums, j+1, numsK)) continue;
                List<Integer> candidate = new ArrayList<>(List.of(nums[i], nums[j], numsK));
                Collections.sort(candidate);
                if (seen.add(candidate)) {
                    results.add(candidate);
                }
            }
        }
        return results;
    }

    public boolean kExists_binarySearch(int[] nums, int low, int target) {
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    // Time: O(n^3)
    // Space: O(n^2)
    //
    // We set j = i+1, and k = j+1 because we don't want different permutations of the same combination.
    // - e.g. (i, j, k) and (j, i, k) and (k, i, j).
    // While it prevents index-level duplication, it doesn't prevent value-level duplication.
    // - e.g. nums = (0, 0, 0, 0)
    //
    // Collections.sort() will cost you O(klogk) to sort k elements. (Uses TimSort)
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
