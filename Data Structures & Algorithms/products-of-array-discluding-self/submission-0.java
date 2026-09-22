class Solution {
    public int[] productExceptSelf(int[] nums) {
        return solution1_bruteForce(nums);
    }

    public int[] solution1_bruteForce(int[] nums) {
        int[] results = new int[nums.length];
        boolean set = false;
        int product = -21;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (!set) {
                    product = nums[j];
                    set = true;
                } else {
                    product = product * nums[j];
                }
            }
            results[i] = product;
            set = false;
        }
        return results;
    }
}  
