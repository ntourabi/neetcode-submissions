class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mainList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if ((i == j) || (j == k) || (i == k)) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> current = new ArrayList<>();
                        current.add(nums[i]);
                        current.add(nums[j]);
                        current.add(nums[k]);
                        mainList.add(current);
                    }
                }
            }
        }
        return mainList;
    }
}
