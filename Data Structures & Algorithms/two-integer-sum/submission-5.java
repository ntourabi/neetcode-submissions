class Solution {
    public int[] twoSum(int[] nums, int target) {
        return solution2(nums, target);
    }

    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            System.out.println(val);
            if (hm.containsKey(val)) {
                int j = hm.get(val);
                if (i == j) continue;
                if (i < j) return new int[]{i, j};
                else return new int[]{j, i};
            }
        }

        throw new RuntimeException("This shouldn't happen.");
    }

    public int[] solution1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    if (i < j) return new int[]{i, j};
                    else return new int[]{j, i};
                }
            }
        }
        throw new RuntimeException("Should not reach here.");
    }
}
