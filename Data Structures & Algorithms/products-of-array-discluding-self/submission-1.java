class Solution {
    public int[] productExceptSelf(int[] nums) {
        return solution1_bruteForce(nums);
    }

    public int[] solution2_x(int[] nums) {
        return null;
    }

    public int[] solution1_bruteForce(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                product *= nums[j];
            }
            results[i] = product;
        }
        return results;
    }
}  
