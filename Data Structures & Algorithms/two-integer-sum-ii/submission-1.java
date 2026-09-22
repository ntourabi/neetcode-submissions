class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return solution1_bruteForce(numbers, target);
    }

    public int[] solution1_bruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                if (numbers[i] + numbers[j] == target) {
                    if (i < j) return new int[]{i+1, j+1};
                    return new int[]{j+1, i+1};
                }
            }
        }
        throw new RuntimeException("We shouldn't reach this.");
    }

}
