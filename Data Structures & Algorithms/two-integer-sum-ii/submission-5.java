class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return solution2_binarySearch(numbers, target);
    }

    public int[] solution2_binarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int low = i+1;
            int high = numbers.length - 1;
            int searchValue = target - numbers[i];
            while (low <= high) {
                int mid = (low + high) / 2;
                if (numbers[mid] == searchValue) {
                    return new int[]{i+1, mid+1};
                } else if (searchValue < numbers[mid]) {
                    high = mid - 1;
                } else if (searchValue > numbers[mid]) {
                    low = mid + 1;
                }
            }
        }
        throw new RuntimeException("Should not reach this.");
    } 

    public int[] solution1_bruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        throw new RuntimeException("We shouldn't reach this.");
    }

}
