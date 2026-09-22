class Solution {
    public int[] twoSum(int[] numbers, int target) {
        return solution3_twoPointers(numbers, target);
    }

    // Time: O(n)
    // Space: O(1)
    public int[] solution3_twoPointers(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int estimate = numbers[left] + numbers[right];
            if (estimate > target) {
                right--;
            } else if (estimate < target) {
                left++;
            } else {
                return new int[]{left+1, right+1};
            }
        }
        throw new RuntimeException("Shouldn't reach here.");
    }


    // Time: O(nlogn)
    // Space: O(1)
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

    // Time: O(n^2)
    // Space: O(1)
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
